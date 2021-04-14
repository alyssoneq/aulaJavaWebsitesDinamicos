package com.toDoApp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet (urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException, ServletException{
		// Requesting the login.jsp file
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}
}
