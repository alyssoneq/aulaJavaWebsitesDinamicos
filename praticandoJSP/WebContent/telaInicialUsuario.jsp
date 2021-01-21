<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Tela inicial </title>
</head>
<body>
	<%-- incluindo página dinâmica com jsp:include --%>
	<jsp:include page="includes/dadosUsuario.jsp">
		<jsp:param value="Junior" name="usuario"/>
	</jsp:include>
</body>
</html>