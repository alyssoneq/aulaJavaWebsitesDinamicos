<%@ include file="/includes/cabecalho.jsp" %>
    <jsp:useBean id="livrariaBean" class="livraria.negocio.LivrariaBean" scope="page" >
    	<jsp:setProperty name="livrariaBean" property="sistema" value="${sistemaLivraria}" />
	</jsp:useBean>
	<!-- Verificando se livro foi adicionado ao carrinho -->
    <c:if test="${not empty param.Add}">
		<c:set var="idL" value="${param.Add}"/>
		<jsp:setProperty name="livrariaBean" property="idLivro" value="${idL}" />
		<c:set var="livroAdicionado" value="${livrariaBean.livro}" />
		<h3>
			<!-- Mensagem é mostrada quando livro for adicionado -->
			<font color="red" size="+2">Você adicionou o livro <em>${livroAdicionado.titulo}</em> ao seu carrinho de compras.</font>
		</h3>
	</c:if>
	<c:choose> 
	 <!-- Verificando se carrinho está vazio -->
     <c:when test="sessionScope.cart.numeroItens > 0">
	     <c:url var="url" value="/livros/mostrarCarrinho">
		     <c:param name="limpar" value="0"/>
		     <c:param name="remover" value="0"/>
	     </c:url>
	     <p>
	     	<!-- link para a página com conteudo do carrinho de compras -->
	     	<a href="${url}">Ver carrinho de compras</a>
	        <c:url var="url" value="/livros/comprar" />
	        <!-- link para efetuar a compra -->
            <strong><a href="${url}">Finalizar compras</a></strong>
         </p>
     </c:when>
     <!-- Conteudo mostrado para carrinho vazio -->
     <c:otherwise>
          Seu carrinho de compras está vazio.
     </c:otherwise>
	</c:choose>  
	<br>
	<br>
	<h3>Livros disponíveis para compra:</h3>
	<div>
	  <table summary="layout">
	  	 <!-- forEach para dispor os livros da coleção livrariaBean.livros -->
	     <c:forEach var="livro" begin="0" items="${livrariaBean.livros}">
	     <tr>
	     	<!-- variavel var=idLivro para armazenar idLivro -->
	     	<c:set var="idLivro" value="${livro.idLivro}" />
			<td bgcolor="#ffffaa">
				<!-- Criando url para acessar detalhes do livro com parametro idLivro -->
			   <c:url var="url" value="/livros/detalhesLivro" >
			      <c:param name="idLivro" value="${idLivro}"/>
			   </c:url>
			   <!-- Dispondo titulo do livro como url -->
			   <a href="${url}"><strong>${livro.titulo}</strong></a>
			</td>
   			<td bgcolor="#ffffaa" rowspan=2>
	     		<!-- Dispondo preço do livro com formato de moeda -->
	      		<fmt:formatNumber value="${livro.preco}" type="currency"/>
          	</td>
          	<td bgcolor="#ffffaa" rowspan=2>
          		<!-- Definindo a URL e parametro add -->
             	<c:url var="url" value="/livros/catalogo" >
	                <c:param name="Add" value="${idLivro}"/>
                </c:url>
                <!-- Gerando a URL na tela -->
                <a href="${url}">Adicionar livro ao carrinho</a>
          	</td>
         </tr>
		 <tr>
		   <td bgcolor="#ffffff">
		        <em>${livro.autores} </em>
		   </td>
		 </tr>
	   	 </c:forEach>
	  </table>
	</div>
<%@ include file="/includes/rodape.jsp" %>