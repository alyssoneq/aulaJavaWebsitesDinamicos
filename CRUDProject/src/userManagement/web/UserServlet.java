package userManagement.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import userManagement.dao.UserDAO;
import userManagement.model.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet(name ="UserServlet", urlPatterns = "/")
public class UserServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
	
	public void Init() {
		this.userDAO = new UserDAO();
	}
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Fetching the action value from the url
		String action = request.getServletPath();
		
		switch (action) {
		case "/new":
			showNewForm(request, response);
			break;
		case "/insert":
			insertUser(request, response);
			break;
		case "/update":
			updateUser(request, response);
			break;
		case "/delete":
			deleteUser(request, response);
			break;
		case "/edit":
			showEditForm(request, response);
			break;

		default:
			// handle the list request
			listUsers(request, response);
			break;
		}
	}

	// Default method to be called on switch statement
	// Return list of users to view 
	private void listUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// fetching data from database
		List<User> users = new ArrayList<User>();
		users = userDAO.selectAllUsers();
		
		// Dispatcher to forward data to the jsp page
		request.setAttribute("listUsers", users);
		RequestDispatcher dispatcher = request.getRequestDispatcher("userList.jsp");
		dispatcher.forward(request, response);
	}
	
	// method to show the create user form
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("userForm.jsp");
		dispatcher.forward(request, response);
	}
	
	// method to handle the create user request
	private void insertUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// fetching data from the request
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		
		// creating user in the database
		User newUser = new User(name, email, country);
		userDAO.insertUser(newUser);
		response.sendRedirect("list");
	}
	
	// method to show the edit user form
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// fetching user by its ID
		int id = Integer.parseInt(request.getParameter("id"));
		User existingUser = userDAO.selectUser(id);
		
		// Redirect to the edit form with the selected user data
		RequestDispatcher dispatcher = request.getRequestDispatcher("userForm.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);
	}
	
	// method to process the update operation
	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// fetching the params
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		
		// Updating the user data using UserDAO class
		User user = new User(id, name, email, country);
		userDAO.updateUser(user);
		response.sendRedirect("list");
		
	}
	
	// Method to process the delete operation
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// getting the id of the user
		int id = Integer.parseInt(request.getParameter("id"));
		
		// deleting the user from the database
		userDAO.deleteUser(id);
		response.sendRedirect("list");
	}
	
}
