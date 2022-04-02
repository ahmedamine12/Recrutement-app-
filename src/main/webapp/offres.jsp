<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Offres</title>

</head>
<body>
	<jsp:include page="/Shared/header.jsp"></jsp:include>

	<div class="container col-6">
	
	


		<c:forEach items="${lo}" var="item">
			<div class="card mt-3">
				<div class="card-header">
					<div class="card-title">
						<c:out value='${item.getTitre()}' />
					</div>
				</div>
					<div class="card-body">
						<c:out value='${item.getType().getLibelle()}' />
						<p class="card-text">
							<c:out value='${item.getDescription()}' />
						</p>
						<a class="btn btn-primary"
							href="<%=request.getContextPath()%>/UserController/modifier?id=${item.getId()}"
							class="card-link">Modifier</a> <a class="btn btn-primary"
							href="<%=request.getContextPath()%>/UserController/supprimer?id=${item.getId()}"
							class="card-link">Supprimer</a>
					</div>
			</div>
		</c:forEach>

	</div>
</body>
</html>