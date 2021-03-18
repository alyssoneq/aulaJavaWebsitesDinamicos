package livros;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import conexao.ConexaoBD;

public class ConsultaLivros {
	
	// Construtor
	public ConsultaLivros() {	
	}
	
	// Método para listar id e nome de todos os livros do banco de dados
	public void listaLivros() throws ClassNotFoundException {
		
		Statement statement = null;
		String serverName = "localhost";
		String myDatabase = "livraria";
		String userName = "root";
		String password = "********";
		Connection conexao = ConexaoBD.conecta(serverName, myDatabase, userName, password);
		
		try {
			statement = (Statement) conexao.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ResultSet result = null;
		
		try {
			String query = "SELECT * FROM livros";
			result = statement.executeQuery(query);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			System.out.println("------------------------------------------");
			while (result.next()) {
				System.out.println(result.getInt("idLivro") + ":  " + result.getString("titulo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			result.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
