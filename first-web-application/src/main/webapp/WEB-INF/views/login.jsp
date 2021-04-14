<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP test</title>
</head>
<body>
	<!-- invalid data alert -->
	<p><font color="red">${errorMessage}</font></p>
	<form action="/login.do" method="post">
		Enter your name: <input type="text" name="name"/> <br>
		Type your password: <input type="password" name="password"/><br>	
		<input type="submit" value="Login"/>
	</form>
</body>
</html>