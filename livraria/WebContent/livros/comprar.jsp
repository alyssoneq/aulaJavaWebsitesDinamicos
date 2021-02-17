<%@ include file="/includes/cabecalho.jsp" %>
<script>
	function comprar(){

		var form = document.getElementById("form");
		var nome = document.getElementById("nome");
		var cartao = document.getElementById("cardnum");
		
		if(nome.value == null || nome.value == ""){
		
		    alert("Digite seu nome");
		    return false;
		
		} else if(cartao.value == null || cartao.value == "" || cartao.value=="xxxx.xxxx.xxxx.xxxx") {
		    alert("Digite o número do cartão");
		    return false;
		} else {
		    form.submit();
		}
	}

	function limparCartao(){
		var cartao = document.getElementById("cardnum");
		
		if(cartao.value == "xxxx.xxxx.xxxx.xxxx"){
		    cartao.value = "";
		}
	}

</script>

<p>Valor total da compra:
<strong>
	<fmt:formatNumber value="${sessionScope.cart.total}" type="currency"/>
</strong>
<p>Para efetuar a compra dos livros selecionados, informe os seguintes dados:
<c:url var="url" value="/livros/recibo" />
<form action="${url}" method="post">
	<table summary="layout">
		<tr>
        	<td><strong>Nome:</strong></td>
		    <td><input type="text" name="nome" value="" size="30"></td>
		</tr>
		<tr>
		    <td><strong>Número do cartão:</strong></td>
		    <td><input type="text" name="cardnum"
   		               value="xxxx xxxx xxxx xxxx" size="19" onfocus="limparCartao()"></td>
		</tr>
		<tr>
			<td></td>
		<td><input type="submit" onclick="comprar()"  value="Comprar"></td>
		</tr>
	</table>
</form>
<%@ include file="/includes/rodape.jsp" %>