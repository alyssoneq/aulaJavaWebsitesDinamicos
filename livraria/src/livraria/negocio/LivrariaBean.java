package livraria.negocio;

import java.util.List;

import livraria.negocio.excecoes.CompraException;
import livraria.negocio.excecoes.LivroNaoEncontradoException;

/*
 * Classe Bean para implementar as operações necessárias para a execução do JSP
 * 
 * */

public class LivrariaBean {
	private Livraria sistema = null;
    private String idLivro = "0";

    public LivrariaBean() {
    }

    public void setIdLivro(String id) {
        this.idLivro = id;
    }

    public void setSistema(Livraria livraria) {
        this.sistema = livraria;
    }

    // Retorna o Livro com id igual ao idLivro
    public Livro getLivro() throws LivroNaoEncontradoException {
        return (Livro) sistema.getLivro(idLivro);
    }

    // Retorna todos os livros em estoque
    public List<Livro> getLivros() {
        return sistema.getLivros();
    }

    // Realiza a compra dos livros no carrinho 
    public void comprarLivros(CarrinhoCompras cart) throws CompraException {
        sistema.comprarLivros(cart);
    }
}