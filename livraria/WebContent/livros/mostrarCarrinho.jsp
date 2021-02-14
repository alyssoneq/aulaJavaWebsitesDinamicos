<%@ include file="/includes/cabecalho.jsp" %>

<!-- Implementando o bean a ser usado nessa p�gina -->
<jsp:useBean id="livrariaBean" class="livraria.negocio.LivrariaBean" scope="page" >
    <jsp:setProperty name="livrariaBean" property="sistema" value="${sistemaLivraria}" />
</jsp:useBean>
<!-- Mensagem para carrinho esvaziado -->
<c:if test="${param.limpar == 'limpar'}">
    <font color="red" size="+2">
    	<strong>O carrinho de compras foi esvaziado!</strong><br> <br>
    </font>
</c:if>
<!-- Mensagem para item removido do carrinho -->
<c:if test="${param.remover != '0'}">
    <c:set var="id" value="${param.remover}"/>
    <jsp:setProperty name="livrariaBean" property="idLivro" value="${id}" />
    <c:set var="livroRemovido" value="${livrariaBean.livro}" />
    <font color="red" size="+2">O seguinte livro foi removido do carrinho:
	    <em>${livroRemovido.titulo}</em>.
	    <br> <br>
    </font>
</c:if>
<!-- Conte�do exibido na tela caso carrinho esteja vazio -->
<c:if test="${sessionScope.cart.numeroItens <= 0}">
    <font size="+2">Carrinho vazio</font>
    <br> <br>
    <c:url var="url" value="/livros/catalogo" >
     	<c:param name="Add" value="" />
    </c:url>
    <strong><a href="${url}">Ver cat�logo</a></strong>
</c:if>

<!-- verificando se h� algo no carrinho para exibir na tela -->
<c:if test="${sessionScope.cart.numeroItens > 0}"> 
    <font size="+2">Quantidade de itens do carrinho: ${sessionScope.cart.numeroItens}
	    <c:if test="{sessionScope.cart.numeroItens == 1}">
			livro.
		</c:if>
		<c:if test="${sessionScope.cart.numeroItens > 1}">
	  		livros.
		</c:if>
	</font><br>
	<!-- Gerando tabela com informa��es do carrinho -->
    <table summary="layout"> 
    <tr> 
        <th align="left">Quantidade</th> 
        <th align="left">T�tulo</th> 
        <th align="left">Pre�o</th> 
    </tr>
    <!-- Exibindo cada item do carrinho com um forEach -->
    <c:forEach var="itemCompra" items="${sessionScope.cart.itens}">
    <c:set var="livro" value="${itemCompra.item}" />
     <tr>
	    <td bgcolor="#ffffff">
	       	<c:url var="url" value="/livros/mostrarCarrinho" >
                <c:param name="alterar" value="${livro.idLivro}" />
                <c:param name="quantidade" value="1" />
                <c:param name="remover" value="0" />
            </c:url>
            <a href="${url}" style="text-decoration: none;">[+]</a>
        </td>
        <td bgcolor="#ffffff">
            <c:url var="url" value="/livros/mostrarCarrinho" >
                <c:param name="alterar" value="${livro.idLivro}" />
                <c:param name="quantidade" value="-1" />
                <c:param name="remover" value="0" />
            </c:url>
            <a href="${url}" style="text-decoration: none;">[-]</a>
        </td> 
        <td align="right" bgcolor="#ffffff"> ${itemCompra.quantidade} </td> 
        <td bgcolor="#ffffaa"> 
            <c:url var="url" value="/livros/detalhesLivro" >
                <c:param name="idLivro" value="${livro.idLivro}" />
                      <c:param name="Clear" value="0" />
            </c:url>
            <strong><a href="${url}">${livro.titulo}</a></strong> 
        </td> 
        <td bgcolor="#ffffaa" align="right"> 
            <fmt:formatNumber value="${livro.preco}" type="currency"/>�</td>   
        <td bgcolor="#ffffaa"> 
            <c:url var="url" value="/livros/mostrarCarrinho" >
              <c:param name="remover" value="${livro.idLivro}" />
            </c:url>
            <strong><a href="${url}">Remover</a></strong> 
        </td>
    </tr>
    </c:forEach>
    <!-- Exibindo valor total da compra -->
    <tr>
        <td colspan="5" bgcolor="#ffffff"> 
        <br></td>
    </tr> 
    <tr> 
        <td colspan="2" align="right" bgcolor="#ffffff">Subtotal</td> 
        <td bgcolor="#ffffaa" align="right"> 
            <fmt:formatNumber value="${sessionScope.cart.total}" type="currency"/>    
        </td>
        <td><br></td>
    </tr>
</table>
<c:url var="url" value="/livros/catalogo" >
  	<c:param name="Add" value="" />
</c:url>
	<strong><a href="${url}">Continuar comprando</a>
<c:url var="url" value="/livros/comprar" />
	<a href="${url}">Finalizar compra</a>
<c:url var="url" value="/livros/mostrarCarrinho" >
	<c:param name="limpar" value="limpar" />
	<c:param name="remover" value="0" />
</c:url>
	<a href="${url}">Esvaziar carrinho</a></strong>
</c:if>
<%@ include file="/includes/rodape.jsp" %>