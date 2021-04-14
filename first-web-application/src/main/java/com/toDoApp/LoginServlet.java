package com.toDoApp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.toDoApp.todo.TodoService;

@WebServlet (urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private userValidationService validationService = new userValidationService();
	private TodoService todoService = new TodoService();
	
	protected void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException, ServletException{
		// Requesting the login.jsp file
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}
	
	// Method to handle post requests
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		boolean isUserValid = validationService.isUserValid(name, password);
		
		// user valid forward to welcome
		if(isUserValid) {
			request.setAttribute("name", name);
			request.setAttribute("todos", todoService.retrieveTodos());
			request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request, response);
		}else {
			request.setAttribute("errorMessage", "Invalidad credentials!");
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		}
	}
}
