<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Confirmation</title>
<link rel="stylesheet" type ="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
</head>
<body>
<%@include file="nav.jsp"%>
<div class= "container  col-md-8 col-md-offset-2">
	<div class = "panel panel-primary">
	<div class = "panel-heading">Confirmation</div>
		<div class = "panel-body">
				<div class = "form-group">
					<label>ID</label>
					<label>${product.id}</label>
				</div>
				<div class = "form-group">
					<label>Description</label>
					<label>${product.des}</label>
				</div>
				<div class = "form-group">
					<label>Price</label>
					<label>${product.price}</label>
				</div>
				<div class = "form-group">
					<label>Quantity</label>
					<label>${product.quantity}</label>
				</div>
					
		</div>
	</div>
</div>
</body>
</html>