<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../components/headerStyles.jsp" />
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<div class="container m-5">
		<div style="width: 100%;max-width: 330px;margin: 0 auto;">
		<jsp:include page="../components/alert.jsp" />
			<div class="card" style="width: 100%;max-width: 330px;margin: 0 auto;">
			  <div class="card-header">
			    Login
			  </div>
			  <div class="card-body">
				<form action="login/submit" method="post">
				  <div class="mb-3">
				    <label for="email" class="form-label">Email address</label>
				    <input type="email" class="form-control" id="email" name="email">
				  </div>
				  <div class="mb-3">
				    <label for="password" class="form-label">Password</label>
				    <input type="password" class="form-control" id="password" name="password">
				  </div>
				  <button type="submit" class="btn btn-primary">Submit</button>
				   <a href="./" class="btn btn-light">Cancel</a>
				</form>
			  </div>
			</div>
		</div>
	</div>
	<jsp:include page="../components/footer.jsp" />
</body>
</html>