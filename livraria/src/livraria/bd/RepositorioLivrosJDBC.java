package livraria.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import livraria.negocio.Livro;
import livraria.negocio.excecoes.LivroNaoEncontradoException;

public class RepositorioLivrosJDBC {
	private Connection conexaoBD; 
	public RepositorioLivrosJDBC() {
		this.conexaoBD = GerenciadorDeConexoes.getConexao();
	}

	public Livro getLivro (String idLivro) throws LivroNaoEncontradoException {

		Livro livro = null;

		try {
			//1. Executa a consulta SQL pra recuperar o livro com esse id
			PreparedStatement st;
			st = this.conexaoBD.prepareStatement("SELECT * FROM livros WHERE idLivro=?", ResultSet.TYPE_SCROLL_SENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE); // Código inserido para evitar erro
			st.setString(1, idLivro);
			ResultSet result = st.executeQuery();
			
			//2. Recupera cada um dos campos do livro, a partir do objeto ResultSet
			if (result.first()) {	
				//3. Instancia o livro com os valores que foram recuperados
				livro = new Livro();
				livro.setIdLivro(result.getString("idLivro"));
				livro.setTitulo(result.getString("titulo"));
				livro.setAutores(result.getString("autores"));
				livro.setAno(result.getInt("ano"));
				livro.setPreco(result.getDouble("preco"));
				livro.setQuantidade(result.getInt("quantidade"));
				livro.setDescricao(result.getString("descricao"));
			}
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new LivroNaoEncontradoException("Não foi possível encontrar o livro: " + idLivro);
		}		

		return livro;
	}

	public List<Livro> getLivros() {
	  
		List<Livro> livros = new ArrayList<Livro>();
		try {
			//1. Executa a consulta SQL pra recuperar todos os livros
			PreparedStatement st;
			st = this.conexaoBD.prepareStatement("SELECT * FROM livros");
			ResultSet result = st.executeQuery();
			
			//2. Para cada livro que for retornado como resultado:
			//a. Recupera cada um dos campos do livro, a partir do objeto ResultSet
			while (result.next()) {
				
				//b. Instancia um livro com os valores que foram recuperados
				Livro livro = new Livro();
				
				livro.setIdLivro(result.getString("idLivro"));
				livro.setTitulo(result.getString("titulo"));
				livro.setAutores(result.getString("autores"));
				livro.setAno(result.getInt("ano"));
				livro.setPreco(result.getDouble("preco"));
				livro.setQuantidade(result.getInt("quantidade"));
				livro.setDescricao(result.getString("descricao"));
				
				//c. Adiciona na lista de livros:);
				livros.add(livro);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return livros;
	}
	
	public int atualizaLivro(String idLivro, Livro livro) {
		int result = 0;
		try {
			//1. Executa a consulta SQL pra recuperar o livro com esse id
			PreparedStatement st;
			st = this.conexaoBD.prepareStatement("UPDATE livros SET idLivro=?, titulo=?, autores=?, ano=?, preco=?, quantidade=?, descricao=? WHERE idLivro=?");
			st.setString(1, idLivro);
			st.setString(2, livro.getTitulo());
			st.setString(3, livro.getAutores());
			st.setInt(4, livro.getAno());
			st.setDouble(5, livro.getPreco());
			st.setInt(6, livro.getQuantidade());
			st.setString(7, livro.getDescricao());
			st.setString(8, livro.getIdLivro());
			result = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	
	// Método main de teste
	public static void main(String[] args) { 
		RepositorioLivrosJDBC repositorioLivros = new RepositorioLivrosJDBC();
		try {
			Livro livro = repositorioLivros.getLivro("0596005407");
			System.out.println(livro.getTitulo());
			
		} catch (LivroNaoEncontradoException e) {
			System.out.println("Livro não encontrado");
		}
		
		try {
			List<Livro> livros = repositorioLivros.getLivros();
			for (Livro livro : livros) {
				System.out.println("Livro: " + livro.getTitulo());
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			String idLivro = "0596005407";
			Livro livro = repositorioLivros.getLivro(idLivro);
			livro.setQuantidade( livro.getQuantidade() - 1);
			int resultado = repositorioLivros.atualizaLivro(idLivro, livro);
			if (resultado > 0) {
				System.out.println("Livro atualizado");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
