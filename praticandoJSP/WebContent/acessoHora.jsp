<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%-- Método para determinar soma de acesso baseado na hora --%>
	<%!
		int contagem = 0;
		int calculaContagem(){
			int valor = 1;
			int hora = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
			if (hora >= 22 || hora <= 6) {
				valor = 2;
			}
			return valor;
		}
	%>
	<%-- Soma do valor para um novo acesso --%>
	<% contagem += calculaContagem(); %>
	Esse é o acesso de número: <%= contagem %>*
	<br>
	*Considere que acesso noturno vale por 2.
</body>
</html>