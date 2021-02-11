package livraria.negocio;

import java.util.*;

/*
 * Classe para definir carrinho de compras
 * Um carrinho de compras possui uma lista ou conjunto de itens
 * O conte�do do carrinho foi modelado como um mapeamento de String
 * O mapeamento dos itens dessa forma permite:
 * 	- garantir tipo de chave do mapeamento seja o mesmo tipo da idLivro
 * 	- valor de cada item do mapeamento ser um objeto ItemCompra
 * 
 * */

public class CarrinhoCompras {
	// Mapeamento de String em objetos do tipo ItemCompra
	Map<String, ItemCompra> itens;

    public CarrinhoCompras() {
        itens = new HashMap<String, ItemCompra>();
    }

    // M�todo para adicionar um item ou unidade de item ao carrinho
    public synchronized void adicionar(Livro book) {
        // Teste l�gico para verificar se o item j� est� no carrinho ou n�o
    	if (itens.containsKey(book.getIdLivro())) {
            ItemCompra item = itens.get(book.getIdLivro());
            item.incrementaQuantidade();
        } else {
            ItemCompra novoItem = new ItemCompra(book);
            itens.put(book.getIdLivro(), novoItem);
        }
    }

    // M�todo para remover uma unidade ou item do carrinho
    public synchronized void remover(String idLivro) {
    	// Teste l�gico para verificar se item j� est� no carrinho, removendo uma unidade
        if (itens.containsKey(idLivro)) {
            ItemCompra item = itens.get(idLivro);
            item.decrementaQuantidade();
            // Teste l�gico para remover item do carrinho
            if (item.getQuantidade() <= 0) {
                itens.remove(idLivro);
            }

        }
    }

    // M�todo para retornar todos os itens comprados
    public synchronized List<ItemCompra> getItens() {
        List<ItemCompra> resultado = new ArrayList<ItemCompra>();
        resultado.addAll(this.itens.values());
        return resultado;
    }

    
    protected void finalize() throws Throwable {
        itens.clear();
    }

    public synchronized int getNumeroItens() {
        int numeroItens = 0;
        for (ItemCompra item : getItens()) {
            numeroItens += item.getQuantidade();
        }
        return numeroItens;
    }

    // M�todo para retornar o valor monet�rio total do carrinho
    public synchronized double getTotal() {
        double total = 0.0;
        for (ItemCompra item : getItens()) {
            Livro book = item.getItem();
            total = total + (item.getQuantidade() * book.getPreco());
        }
        return total;
    }

    // M�todo para retirar todos os itens do carrinho
    public void limpar() {
        itens.clear();
    }
}
