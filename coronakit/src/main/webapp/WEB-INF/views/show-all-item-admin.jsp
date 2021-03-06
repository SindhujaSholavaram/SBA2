<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin - Items List</title>
</head>
<body>
	<jsp:include page="/header" />
	<section class="container-fluid p-4">
	<h3>PRODUCTS</h3>
	
	<c:choose>
		<c:when test="${products==null || products.isEmpty() }">
			<p class="alert alert-info p-2 m-2">No Products Found</p>
		</c:when>
		<c:otherwise>
			<table class="table table-stripped table-bordered table-hover">
				<tr>
					<th>ID</th>
					<th>Product Name</th>
					<th>Cost</th>
					<th>Product Description</th>
				</tr>
				<c:forEach items="${products }" var="product">
					<tr>
					<td>${product.id }</td>
					<td>${product.productName }</td>
					<td>${product.cost }</td>
					<td>${product.productdescription }</td>
					<td>
						<a class = "btn btn-sm btn-danger" href="/product-delete?id=${product.id }">DELETE</a> <span>|</span>
						<a class = "btn btn-sm btn-primary" href="/product-edit?id=${product.id }">EDIT</a>
					</td>
				</tr>				
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
	</section>
</body>
</html>