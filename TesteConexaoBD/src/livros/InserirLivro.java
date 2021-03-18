package livros;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.ConexaoBD;

/**
 * Classe para inserir dados no banco de dados livraria
 * 
 * */
public class InserirLivro {
	
	// Construtor
	public InserirLivro() {
		
	}
	
	// Método para um inserir um livro no banco de dados
	public void inserir(String idLivro, String titulo, String autores, int ano, double preco, int quantidade, String descricao) throws ClassNotFoundException {
		PreparedStatement statement = null;
		String serverName = "localhost";
		String myDatabase = "livraria";
		String userName = "root";
		String password = "********";
		Connection conexao = ConexaoBD.conecta(serverName, myDatabase, userName, password);
		
		try {
			String query = "INSERT INTO livros (idLivro, titulo, autores, ano, preco, quantidade, descricao) VALUES (?,?,?,?,?,?,?);";
			statement = (PreparedStatement) conexao.prepareStatement(query);
			
			statement.setString(1, idLivro);
			statement.setString(2, titulo);
			statement.setString(3, autores);
			statement.setInt(4, ano);
			statement.setDouble(5, preco);
			statement.setInt(6, quantidade);
			statement.setString(7, descricao);
			
			statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
