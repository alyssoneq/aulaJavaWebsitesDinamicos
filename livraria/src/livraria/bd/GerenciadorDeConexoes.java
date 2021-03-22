package livraria.bd;

import java.sql.Connection;
import java.sql.DriverManager;

/* *
 * Classe responsável por carregar o driver
 * Também
 * */
public class GerenciadorDeConexoes {
public static java.sql.Connection getConexao() { 

	      Connection connection = null;// atributo do tipo Connection 
	      String driverName = "com.mysql.cj.jdbc.Driver"; 
	      String serverName = "localhost";// caminho do servidor do BD 
	      String mydatabase = "livraria";// nome do seu banco de dados 
	      String url = "jdbc:mysql://" + serverName + "/" + mydatabase; 
	      //url += "?serverTimezone=UTC"; // Adicione/remova essa linha se tiver problemas em conectar com seu servidor MySQL
	      String username = "root";// nome de um usuário de seu BD       
	      String password = "********";// sua senha de acesso 

	      try { 
	            Class.forName(driverName);
	            connection = DriverManager.getConnection(url, username, password);
	      } catch (Exception e) { 
	            e.printStackTrace();
	      }
	      return connection;
	}
	
	public static void main(String[] args) { 
		Connection conexao = getConexao();
	}
}