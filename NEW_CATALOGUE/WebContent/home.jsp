<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Products</title>
<link rel="stylesheet" type ="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
</head>
<body>
<%@include file="nav.jsp"%>
<div class= "container  col-md-10 col-md-offset-1">
	<div class = "panel panel-primary">
	<div class = "panel-heading">Search for Products</div>
		<div class = "panel-body">
			<form action="search.yo" method="get">
				<label>Key Word</label>
				<input type ="text" name="key" value="${model.keyWord}"/>
				<button type="submit" class="btn btn-primary">Search</button>
			</form>
			<hr>

			<table class="table table-striped">
				<tr>
    					<th>Id</th>
   					<th>Description</th> 
    					<th>Price</th>
    					<th>Quantity</th>
  				</tr>
  				<c:forEach items="${model.products}" var="p">
  					<tr>
  						<td>${p.id}</td>
  						<td>${p.des}</td>
  						<td>${p.price}</td>
  						<td>${p.quantity}</td>
  						<td><a onClick = "return confirm('Are you sure you want to delete this product?')" href="delete.yo?id=${p.id}" class="btn btn-danger">Delete</a></td>
  						<td><a href="edit.yo?id=${p.id}" class="btn btn-success">Edit</a></td>
  					</tr>
  				</c:forEach>
			</table>
		</div>
	</div>
</div>
</body>
</html>