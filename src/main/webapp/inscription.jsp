<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<form method="post" action="<%=request.getContextPath()%>/UserController/inscription">
			<div class="form-group row">
				<label for="nom" class="col-sm-2 col-form-label">Nom :</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="nom" name="nom">
				</div>
			</div>


			<div class="form-group row">
				<label for="prenom" class="col-sm-2 col-form-label">Prenom :</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="prenom" id="prenom">
				</div>
			</div>

			<div class="form-group row">
				<label for="email" class="col-sm-2 col-form-label">Email :</label>
				<div class="col-sm-10">
					<input type="email" name="email" class="form-control" id="email">
				</div>
			</div>
			
			<div class="form-group row">
				<label for="password" class="col-sm-2 col-form-label">Password :</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" name="password" id="password">
				</div>
			</div>


			<div class="form-group row">
				<div class="col-sm-10">
					<button type="submit" class="btn btn-primary">Sign in</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>