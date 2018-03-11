<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Product</title>
<link rel="stylesheet" type ="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
</head>
<body>
<%@include file="nav.jsp"%>
<div class= "container  col-md-8 col-md-offset-2">
	<div class = "panel panel-primary">
	<div class = "panel-heading">Update a product</div>
		<div class = "panel-body">
			<form action="updateProduct.yo" method="post">
				<div class = "form-group">
					<label class = "control-label">ID</label>
					<input class = "form-control" type ="hidden" name="id" value = "${product.id}"/>
					<label>${product.id}</label>
					<span></span>
				</div>
				<div class = "form-group">
					<label class = "control-label">Description</label>
					<input class = "form-control" type ="text" name="inputDes" value = "${product.des}"/>
					<span></span>
				</div>
				<div class = "form-group">
					<label class = "control-label">Price</label>
					<input class = "form-control" type ="text" name="inputPrice" value = "${product.price}"/>
					<span></span>
				</div>
				<div class = "form-group">
					<label class = "control-label">Quantity</label>
					<input class = "form-control" type ="text" name="inputQuantity" value = "${product.quantity}"/>
					<span></span>
				</div>
				<button type="submit" class="btn btn-primary">Save</button>
			</form>
		</div>
	</div>
</div>
</body>
</html>