package userManagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import JDBC.DBConnection;
import userManagement.model.User;

/* *
 * Data Access Object class for a user
 * provides CRUD operations for the table users
 *  
 * */
public class UserDAO {
	
	
	// Defining SQL statements
	private static final String INSERT_USERS = "INSERT INTO users(name, email, country) VALUES(?,?,?)";
	private static final String SELECT_USER_BY_ID = "SELECT id, name, email, country FROM users WHERE id = ? ";
	private static final String SELECT_ALL_USERS = "SELECT * FROM users";
	private static final String DELETE_USERS = "DELETE FROM users WHERE id=?";
	private static final String UPDATE_USERS = "UPDATE users SET name=?, email=?, country=? WHERE id=?";
	
	// Insert user in the database
	public void insertUser(User user) {
		// try-with-resources
		try(Connection connection = DBConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS) ) {
			
			// Defining the new user for the query
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getCountry());
			
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Select user from table by ID
	public User selectUser(int id) {
		User user = null;
		
		//try-with-resources
		try (Connection connection =  DBConnection.getConnection();
			 PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID)) {
			
			// Setting the id param in the query
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			// Populating the user with data retrieved
			while (resultSet.next()) {
				String name = resultSet.getString("name");
				String email = resultSet.getString("email");
				String country = resultSet.getString("country");
				
				user = new User(name, email, country);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
		
	}
	
	// Select all users from the table users
	public List<User> selectAllUsers() {
		List<User> users = new ArrayList<User>();
		
		// try-with-resource
		try (Connection connection = DBConnection.getConnection();
			 PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS)) {
			
			// Executing the query
			ResultSet resultSet = preparedStatement.executeQuery();
			
			// Populating the users list
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String email = resultSet.getString("email");
				String country = resultSet.getString("country");
				
				users.add(new User(id , name, email , country));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return users;
	}
	
	// Delete user from users table
	public boolean deleteUser(int id){
		boolean rowDeleted = false;
		
		// try-with-resources
		try(Connection connection = DBConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS)	){
			
			// Defining the params for the query
			preparedStatement.setInt(1, id);
			rowDeleted = preparedStatement.executeUpdate() > 0;
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rowDeleted;
	}
	
	// Update data inside the users table
	public boolean updateUser(User user)  {
		
		boolean rowUpdated = false;
		
		//try-with-resources
		try(Connection connection = DBConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS)	){
			
			// Populating the query with the new user data
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getCountry());
			preparedStatement.setInt(4, user.getId());
			
			rowUpdated = preparedStatement.executeUpdate() > 0;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rowUpdated;
	}
}
