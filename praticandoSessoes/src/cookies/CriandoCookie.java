package cookies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CriandoCookie
 * 
 * Servlet usado para praticar a criação de um cookie de sessão
 */
@WebServlet("/CriandoCookie")
public class CriandoCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CriandoCookie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Criando cookie 
		Cookie myCookie = new Cookie("MeuCookie", "Biscoito");
		// Método para definir duração do cookie na sessão, em segundos
		myCookie.setMaxAge(60);
		// Método para definir se cookie é enviado por HTTP padrão
		myCookie.setSecure(false);
		// Método para gerar comentário acerca do cookie
		myCookie.setComment("Primeiro cookie");
		// Método para adicionar o cookie à memoria do PC
		response.addCookie(myCookie);
		
		PrintWriter output = response.getWriter();
		String html = "<html>"
					+ "<head><title> Criando cookie</title></head>"
					+ "<body>"
					+ "<h2> Seu cookie foi criado com sucesso!! </h2>"
					+ "<a href=\"VisualizaCookie\">"
					+ " Clique aqui para ver o cookie criado "
					+ "</a>"
					+ "</body></html>";
		response.setContentType("text/html");
		output.print(html);
		output.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
