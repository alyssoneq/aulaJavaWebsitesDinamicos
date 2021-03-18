package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe para conectar com um banco de dados
 * 
 * */
public class ConexaoBD {
	
	// M�todo de conex�o com o banco de dados
	public static Connection conecta(String serverName, String myDatabase, String userName, String password) throws ClassNotFoundException {
		
		Connection conexao = null;
		
		String driverName = "com.mysql.cj.jdbc.Driver";
		Class.forName(driverName);
		String url = "jdbc:mysql://" + serverName + "/" + myDatabase;
		
		try {
			conexao = DriverManager.getConnection(url, userName, password);
			System.out.println("conex�o estabelecida com sucesso!");
			
		} catch (SQLException e) {
			System.err.println("Erro na conex�o...");
		}
		
		return conexao;
		
	}
}
