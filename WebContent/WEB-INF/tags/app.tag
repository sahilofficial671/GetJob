<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@attribute name="body" fragment="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
	<%@include file="../../components/headerStyles.jsp" %>
		<style>
			<%@include file="../../assets/css/style.css" %>
		</style>
		<meta charset="ISO-8859-1">
		<title>Get Job | Getjob.com</title>
	</head>
	<body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">
		<%@include file="../../components/navbar.jsp" %>
		<jsp:invoke fragment="body"/>
		<%@include file="../../components/footer.jsp" %>
	</body>
</html>