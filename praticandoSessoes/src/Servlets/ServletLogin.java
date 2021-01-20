package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletLogin
 *
 * Servlet criado para processar dados de login do usu�rio
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String USUARIO = "usuario";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter output = response.getWriter();
		
		output.write("<html><body>");
		// Coletando parametros enviados pelo usuario
		String nomeUsuario = request.getParameter(USUARIO);
		String senhaUsuario = request.getParameter("senha");
		// Verificando login corret com m�todo autenticar()
		if (autenticar(nomeUsuario, senhaUsuario)) {
			// login correto
			// Configura sess�o por meio do m�todo getSession()
			HttpSession session = request.getSession();
			session.setAttribute(USUARIO, nomeUsuario);
			output.write("Bem vindo, " + nomeUsuario);
		} else {
			output.write("Usu�rio e senha inv�lidos");
		}
		output.write("</body></html>");
	}
	
	private boolean autenticar(String nomeUsuario, String senhaUsuario) {
		// Processo de autentica��o
		// Por enquanto, apenas verifica vazio ou n�o
		return !( "".equals(nomeUsuario) || "".equals(senhaUsuario) || nomeUsuario == null || senhaUsuario == null ) ;
		
	}

}
