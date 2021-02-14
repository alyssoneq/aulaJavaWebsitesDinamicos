package livraria.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import livraria.negocio.CarrinhoCompras;
import livraria.negocio.Livraria;
import livraria.negocio.Livro;
import livraria.negocio.excecoes.CompraException;
import livraria.negocio.excecoes.LivroNaoEncontradoException;

/**
 * Servlet controlador do sistema
 * Acessa o sistema
 * Acessa ou cria a sessão
 * Acessa ou cria o carrinho de compras
 * 
 */
@WebServlet(name="Controlador", urlPatterns= {"/livros/livraria","/livros/catalogo", "/livros/detalhesLivro","/livros/mostrarCarrinho","/livros/comprar","/livros/recibo"})
public class ServletControladorLivraria extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		String idLivro = null;
	    String limpar = null;
	    Livro livro = null;
	    Livraria livraria = (Livraria) getServletContext().getAttribute(
	    LivrariaContextListener.SISTEMA_LIVRARIA);
	    // Acessando / criando sessão
	    HttpSession session = request.getSession();

	    // Acessando carrinho de compras
	    CarrinhoCompras carrinho = (CarrinhoCompras) session.getAttribute("cart");
	    // Caso não exista carrinho criado, então isso é feito
	    if (carrinho == null) {
	        carrinho = new CarrinhoCompras();
	        session.setAttribute("cart", carrinho);
	    }

	    // Caminho da URL define qual serviço será executado
	    String acaoSelecionada = request.getServletPath();

	    // Operações do sistema
	    if (acaoSelecionada.equals("/livros/catalogo")) {
	        idLivro = request.getParameter("Add");

	        if (!idLivro.equals("")) {
	              try {
	                    livro = livraria.getLivro(idLivro);
	                    carrinho.adicionar(livro);
	              } catch (LivroNaoEncontradoException ex) {
	                    // isso não deve acontecer
	              }
	        }
	    }else if (acaoSelecionada.equals("/livros/mostrarCarrinho")) {
            idLivro = request.getParameter("remover");
            // Caso alguma id for passada, item será removido do carrinho  
		    if (idLivro != null) {
		        carrinho.remover(idLivro);
		    }
	        // Esvazia carrinho se o parametro limpar = "limpar"         
			limpar = request.getParameter("limpar");
			    
			if ((limpar != null) && limpar.equals("limpar")) {
			    carrinho.limpar();
			}
			// Executando operação de aumentar ou diminuir quantidade no carrinho
			idLivro = request.getParameter("alterar");

			  if (idLivro != null) { 
			   int quantidade = Integer.parseInt(request.getParameter("quantidade")); 

			   if(quantidade == 1){ 
			    carrinho.aumentarQuantidade(idLivro);
			   }
			   else if(quantidade == -1){ 
			    carrinho.diminuirQuantidade(idLivro); 

			   }
		  	}
		// Efetuando a compra dos itens do carrinho	
	    }else if (acaoSelecionada.equals("/livros/recibo")) {
	        try {
	            livraria.comprarLivros(carrinho);
	        } catch (CompraException ex) {
	            ex.printStackTrace();
	        }
		}
	    

	    // Definindo qual tela será requisitada
	    String tela = acaoSelecionada + ".jsp";

	    try {
	    	request.getRequestDispatcher(tela).forward(request, response);
	    } catch (Exception ex) {
	         ex.printStackTrace();
	    }
	}

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        doGet(request, response);
    }
}
