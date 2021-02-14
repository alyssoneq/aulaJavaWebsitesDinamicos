<%@ include file="/includes/cabecalho.jsp" %>
<!-- Implementando o bean no escopo da página -->
<jsp:useBean id="livrariaBean" class="livraria.negocio.LivrariaBean" scope="page">
<jsp:setProperty property="sistema" name="livrariaBean" value="${sistemaLivraria}"/>
</jsp:useBean>

<!-- Criando objeto livro baseado na id passada como parametro -->
<c:if test="${!empty param.idLivro}">
<c:set var="id" value="${param.idLivro}"/>
<jsp:setProperty name="livrariaBean" property="idLivro" value="${id}" />
<c:set var="livro" value="${livrariaBean.livro}" />

<!-- Organizando as informações sobre o livro, na tela -->
<h2>${livro.titulo}</h2>
Autoria de  <em> ${livro.autores}</em>
(${livro.ano})<br>   <br>
<h4>Descrição</h4>
<blockquote>${livro.descricao}</blockquote>
<h4>Preço: <fmt:formatNumber value="${livro.preco}" type="currency"/></h4>

<!-- URL para adicionar o livro ao carrinho -->
<c:url var="url" value="/livros/catalogo" >
    <c:param name="Add" value="${id}" />
</c:url> 
    <p><strong><a href="${url}">Adicionar ao carrinho</a>     
</c:if>

<!-- URL para voltar ao catálogo -->
<c:url var="url" value="/livros/catalogo">
	<c:param name="Add" value=""></c:param>
</c:url>
<a href="${url}"> Continuar comprando </a></strong></p>

<%@ include file="/includes/rodape.jsp" %>