<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>
<div class="container">


<div class=" row col-md-10 ">

			<div class=" card card-body mt-5">

				<h2>Modifier d'offre : </h2>
				<div class="col-md-8 col-md-offset-3">

					<form action="<%=request.getContextPath()%>/UserController/updateOffre"
						method="post">
						<input type="hidden" name="id" value="${offre.id}">
						<div class="form-group">
							<label for="titre">Titre:</label> <input type="text"
								class="form-control" id="titre" placeholder="Titre de l'offre"
								name="titre" 
								value='<c:out value="${offre.titre}"></c:out>' required>
						</div>

						<div class="form-group">
							<label for="description">description:</label> <input type="text"
								class="form-control" id="description"
								placeholder="description de l' offre" name="description"
								value='<c:out value="${offre.description}"></c:out>'
								required>
						</div>
						<div class="form-group ">
							<label for="inputType">Type</label> 
							<select id="inputType" name="inputType" class="form-control">
								<option value ="cdi" ${offre.type.getLibelle().equals("cdi") ? 'selected' : ''}>CDI</option>
								<option value ="cdd" ${offre.type.getLibelle().equals("cdd") ? 'selected' : ''}>CDD</option>
								<option value ="stage" ${offre.type.getLibelle().equals("stage") ? 'selected' : ''}>Stage</option>
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