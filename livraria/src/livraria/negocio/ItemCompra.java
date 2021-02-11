package livraria.negocio;

/**
 * Classe para modelar um item adicionado ao carrinho
 * O carrinho da livraria recebe livros
 * Um item de compra � identificado por:
 * 	- item (� um livro)
 * 	- quantidade a ser comprada
 * 
 **/
public class ItemCompra {
	private Livro item;
    private int quantidade;
    
    // Construtor ao ser criado recebe um livro
    public ItemCompra(Livro prod) {
		item = prod;
		setQuantidade(1);
	}
    
    //M�todo para adicionar 1 unidade de um item
    public void incrementaQuantidade() {
		setQuantidade(getQuantidade() + 1);
	}
    
    // M�todo para remover 1 unidade de um item
    public void decrementaQuantidade() {
		setQuantidade(getQuantidade() - 1);
	}
    
    public Livro getItem() {
		return item;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
    
    
}
