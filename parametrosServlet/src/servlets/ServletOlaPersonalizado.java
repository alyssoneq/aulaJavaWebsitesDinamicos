package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletOlaPersonalizado
 * 
 * Servlet criado para testar funcionalidade GET
 * O método doGet() receberá parâmetros para processar
 */
@WebServlet("/ServletOlaPersonalizado")
public class ServletOlaPersonalizado extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletOlaPersonalizado() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Método com parâmetros recebido pela URL
		String nome = request.getParameter("nome");
		String idade = request.getParameter("idade");
		
		// Pequeno código html para inserir o nome na tela
		String html = "<html><body><h1>" +
						nome +
						"<p> idade: "+
						idade +
						" anos </p></h1></body></html>";
		response.getWriter().append(html);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	
}
