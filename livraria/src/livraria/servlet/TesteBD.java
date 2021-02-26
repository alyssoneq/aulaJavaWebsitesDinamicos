package livraria.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TesteBD")
public class TesteBD extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String driverName = "com.mysql.cj.jdbc.Driver"; 
		PrintWriter writer = response.getWriter();
		
        
		try { 
            Class.forName(driverName);
            writer.append("Driver JDBC carregado com sucesso");
        } catch (ClassNotFoundException e) {
            writer.append("Driver não carregado!");
            e.printStackTrace();
        }
	}
}