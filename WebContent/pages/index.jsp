<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../components/headerStyles.jsp" />
<meta charset="ISO-8859-1">
<title>Get Job | Getjob.com</title>
</head>
	<body>
		<div class="container m-5">
			<div style="width: 100%;max-width: 330px;margin: 0 auto;">
				<jsp:include page="../components/alert.jsp" />
				<div class="card">
				  <div class="card-header">
				    Home Page
				  </div>
				  <div class="card-body">
					<a href="login" class="btn btn-primary">Login</a>
					<a href="register" class="btn secondary">Register</a>
				  </div>
				</div>
			</div>
		</div>
		<jsp:include page="../components/footer.jsp" />
	</body>
</html>