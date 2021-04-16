package com.toDoApp.todo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/todo.do")
public class TodoServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private TodoService todoService = new TodoService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		List<Todo> todos = new ArrayList<Todo>();
		todos = todoService.retrieveTodos();
		request.setAttribute("todos", todos);
		request.getRequestDispatcher("/WEB-INF/views/todo.jsp").forward(request, response);;
		
	}
}
