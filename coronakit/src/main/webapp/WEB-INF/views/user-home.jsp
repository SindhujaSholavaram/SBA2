<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home - User</title>
</head>
<body>
<nav>
		<a href="${pageContext.request.contextPath}/user/show-list">Items List</a> <span>||</span>
		<a href="${pageContext.request.contextPath}/user/show-kit">Kit Details</a> <span>||</span> 
		<a href="${pageContext.request.contextPath}/logout">LOGOUT</a>
	</nav>
</body>
</html>