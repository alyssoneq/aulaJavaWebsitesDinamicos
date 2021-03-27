<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- This page display a list of all users -->
<html>
<head>
<title>CRUD app</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

</head> 
<body>
<header>
	<nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
		<div>
		<a href="<%=request.getContextPath()%>/list" class="navbar-brand"> CRUD App </a>
		</div>

		<ul class="navbar-nav">
			<li><a href="<%=request.getContextPath()%>/list" class="nav-link">Users</a></li>
		</ul>
	</nav>
</header>
<br>

<div class="row">
	<div class="container">
		<h3 class="text-center">List of users</h3>
		<hr>
		<div class="container text-left">
			<a href="<%=request.getContextPath()%>/new" class="btn btn-success"> Add New User</a>		
		</div>
		<br>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Email</th>
					<th>Country</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<!-- loop ==> (User user: listUsers) -->
				<c:forEach var="user" items="${listUsers}">
					<tr>
						<td><c:out value="${user.id}"/></td>
						<td><c:out value="${user.name}"/></td>
						<td><c:out value="${user.email}"/></td>
						<td><c:out value="${user.country}"/></td>
						<td>
							<a href="edit?id=<c:out value='${user.id}' />"> Edit </a>
							&nbsp;&nbsp;&nbsp;
							<a href="delete?id=<c:out value='${user.id}' />"> Delete </a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>

</body>
</html>