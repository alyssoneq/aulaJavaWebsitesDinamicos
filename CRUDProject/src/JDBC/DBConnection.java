package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/* *
 * Class to manage the database connection
 * 
 * */

public class DBConnection {

	// Connection params
	private static final String url = "jdbc:mysql://localhost:3306/crud?useSSL=false";
	private static final String userName = "root";
	private static final String password = "********";
	
	// Method to connect with the database
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, userName, password);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return connection;
	}
}
