<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Checkout</title>
</head>
<body>
<spring:form action="${pageContext.request.contextPath}/finalize" method="POST" modelAttribute="checkout">
<br/><br/>
<spring:label path="id">ID:</spring:label>
<spring:input path="id"/>
<br/><br/>

<spring:label path="deliveryAddress">Delivery Address</spring:label>
<spring:input path="deliveryAddress"/>
<br/><br/>

<spring:label path="orderDate">Order Date</spring:label>
<spring:input path="orderDate"/>
<br/><br/>

<spring:label path="totalAmount">Total Amount</spring:label>
<spring:input path="totalAmount"/>
<br/><br/><br/>

<input type="submit" value="Finalize">


</spring:form>
</body>
</html>