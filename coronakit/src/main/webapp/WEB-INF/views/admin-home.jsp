<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Home</title>
</head>
<body>
	<h1>This is Admin dashboard</h1>
	<nav>
		<a href="${pageContext.request.contextPath}">HOME</a> <span>||</span>
		<a href="${pageContext.request.contextPath}/admin/product-list">Items List</a> <span>||</span>
		<a href="${pageContext.request.contextPath}/admin/product-entry">Add New Product</a> <span>||</span> 
		<a href="${pageContext.request.contextPath}/logout">LOGOUT</a>
	</nav>
</body>
</html>