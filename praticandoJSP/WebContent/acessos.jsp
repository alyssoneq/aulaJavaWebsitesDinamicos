<%@page import="tools.Contador"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Contador acessos </title>
</head>
<body>
	<!-- Executando m�todo via scriplet -->
	<% Contador.novoAcesso(); %> Quantidade de acessos a essa p�gina:
	<!-- Imprimindo valor de acessos por meio do m�todo da classe Contador -->
	<b> <%= Contador.getQuantidadeAcessos() %> </b>
</body>
</html>