package cookies;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VisualizaCookie
 * 
 * Servlet para visualizar cookie de uma sessão
 */
@WebServlet("/VisualizaCookie")
public class VisualizaCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualizaCookie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Método getCookies() pega os dados dos cookies da sessão
		Cookie listCookies[] = request.getCookies();
		Cookie name = null;
		// Teste if para determinar o cookie correspondente ao usuário
		if (listCookies !=null) {
			for (int i = 0; i < listCookies.length; i++) {
				// Teste lógico para atribuir cookie do usuario à variável name
				if (listCookies[i].getName().equals("MeuCookie")) {
					name = listCookies[i];
					break;
				}
			}
		}
		
		String html = "<html>"
					+ "<head><title> Visualiza Cookie </title> </head>"
					+ "<body>"
					+ "O cookie chamado <strong> Meu Cookie </strong> tem o valor: "
					+ "<strong>" + name.getValue() + "</strong>"
					+ "</body></html>";
		
		response.setContentType(html);
		response.getWriter().write(html);
		response.getWriter().close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
