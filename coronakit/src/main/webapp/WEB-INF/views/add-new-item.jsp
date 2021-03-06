<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Item</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmY1"
	crossorigin="anonymous"></script>

</head>
<body>
	<jsp:include page="/header" />
	<section class="container-fluid p-4">
		<h3>${isNew? "New Item" : "Edit Item" }</h3>
		<div class="col-4">
			<form:form class="form"
				action='${isNew?"product-entry":"product-save" }' method="POST"
				modelAttribute="product">
				<div class="form-group">
					<form:label path="id" class="form-label">ID:</form:label>
					<form:input type="number" path="id" readonly="${!isNew}"
						class="form-control" />
					<form:errors path="id" class="alert alert-danger" />
				</div>

				<div class="form-group">
					<form:label path="productName" class="form-label">Product Name:</form:label>
					<form:input type="text" path="productName" class="form-control" />
					<form:errors path="productName" class="alert alert-danger" />
				</div>

				<div class="form-group">
					<form:label path="cost" class="form-label">Cost:</form:label>
					<form:input type="number" path="cost" readonly="${!isNew}"
						class="form-control" />
					<form:errors path="cost" class="alert alert-danger" />
				</div>

				<div class="form-group">
					<form:label path="productDescription" class="form-label">Product Description:</form:label>
					<form:input type="text" path="productDescription"
						class="form-control" />
					<form:errors path="productDescription" class="alert alert-danger" />
				</div>

				<div class="text-right">
					<button class="btn btn-primary">SAVE</button>
				</div>
				
			</form:form>
		</div>
	</section>
</body>
</html>