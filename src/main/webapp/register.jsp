<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<body>
<jsp:include page="/Shared/header.jsp"></jsp:include>
	<c:if test="${user.getType().equals('a')}">
		<c:out value="${user.getFirstName()}"></c:out>
	</c:if>
	<div class="container">
		<div class="row text-center" style="color: tomato;">
			<h2>Ajout d'offre</h2>
		</div>
		<hr>
		<div class="row col-md-10">

			<div class="card card-body">

				
				<div class="col-md-8 col-md-offset-3">

					<form action="<%=request.getContextPath()%>/UserController/inserer" enctype="multipart/form-data" method="post">

						<div class="form-group">
							<label for="titre">Titre:</label> <input type="text"
								class="form-control" id="titre" placeholder="Titre de l'offre"
								name="titre" required>
						

						<div class="form-group">
						<label for="titre">CV:</label>
						<input type="file" name="cv" size="50"/>
						</div>
						<div class="form-group">
						<label for="titre">Lettre de Motivation</label>
						<input type="file" name="lettre" size="50"/>
						</div>
							<label for="description">description:</label> <input type="text"
								class="form-control" id="description"
								placeholder="description de l' offre" name="description"
								required>
								<div>
						</div>
						<div class="form-group ">
							<label for="inputType">Type</label> <select id="inputType"
								name="inputType" class="form-control">
								<option value="cdi">CDI</option>
								<option value="cdd">CDD</option>
								<option value="stage">Stage</option>
							</select>
						</div>

						<button type="submit" class="btn btn-primary">Submit</button>

					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>