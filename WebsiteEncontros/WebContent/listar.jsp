<%@page import="model.Encontro"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de encontros</title>
</head>
<body>
	<h3> Lista de encontros </h3>
	<table border="1">
		<tr>
			<td>Nome</td>
			<td>Local</td>
			<td>Motivo</td>
			<td>Data</td>
		</tr>
		<!-- Gerando a lista de encontros -->
		<%
		List<Encontro> lista = (List<Encontro>) request.getAttribute("lista");
		for(Encontro encontro : lista){
		%>
		<tr>
			<td> <%= encontro.getNomePessoa() %></td>
			<td> <%= encontro.getLocal() %></td>
			<td> <%= encontro.getMotivo() %></td>
			<td> <%= encontro.getData().toLocaleString() %></td>
		</tr>
		<%
		}
		%>
	</table>
	<br><br>
	<a href="ServletControlador"> Voltar ao Menu </a>
</body>
</html>