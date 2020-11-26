<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error</title>
</head>
<body>
<h1>Un-Authorized Access...</h1>
<a href="${pageContext.request.contextPath}/">HOME</a>

<h3>Error: ${errMsg}</h3>
<p>Sorry for the Inconvenience caused. Kindly report to Admin, if issue persists.</p>

</body>
</html>