<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- JSP page to display the user form  -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Form</title>
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
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Users</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<!-- checking for a user object from the dispatcher -->
				<c:if test="${user != null}">
					<form action="update" method="post" >				
				</c:if>
				
				<c:if test="${user == null}">
					<form action="insert" method="post" >				
				</c:if>
				
				<caption>
					<h2>
					<c:if test="${user != null }">
						Edit User
					</c:if>
											
					<c:if test="${user == null }">
						Add New User
					</c:if>
					</h2>
				</caption>
				<!-- Id hidden when a user is being updated -->
				<c:if test="${user != null }">
					<input type="hidden" name="id" value="<c:out value='${user.id}'/>" />
				</c:if>
				
				<fieldset class ="form-group">
					<label> User Name 
					<input type="text" name="name" value="<c:out value='${user.name }'/>" class="form-control" required="required" /> 
					</label>
				</fieldset>
				
				<fieldset class ="form-group">
					<label> User Email
					<input type="text" name="email" value="<c:out value='${user.email }'/>" class="form-control" /> 
					</label>
				</fieldset>
				
				<fieldset class ="form-group">
					<label> User Country 
					<input type="text" name="country" value="<c:out value='${user.country }'/>" class="form-control" /> 
					</label>
				</fieldset>
				
				<button type="submit" class="btn btn-success" >Save</button>
				</form>
			</div>
		
		</div>
	
	</div>
</body>
</html>