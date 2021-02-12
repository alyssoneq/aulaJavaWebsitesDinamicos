<%@ include file="/includes/cabecalho.jsp" %>
        <p><b>Livraria Online</b></p>
        <!-- definindo URL para acessar o catalogo -->
        <c:url var="url" value="/livros/catalogo" />
        <!--  -->
        <p><b><a href="${url}?Add=">Iniciar compras</a></b>
<%@ include file="/includes/rodape.jsp" %>