<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
<jsp:include page="${pageContext.request.contextPath }/header" />
<h1>Welcome to Corona-Kit Home...</h1>
<hr/>
<a href="${pageContext.request.contextPath}/custom-login"><input type="button" value="Login" /></a>
<hr/>
<jsp:include page="${pageContext.request.contextPath }/footer" />
</body>
</html>