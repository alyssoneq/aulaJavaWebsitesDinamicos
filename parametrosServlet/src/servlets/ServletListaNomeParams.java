package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletListaNomeParams
 * 
 * Servlet criado para listar os par�metros recebidos por ele
 */
@WebServlet("/ServletListaNomeParams")
public class ServletListaNomeParams extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListaNomeParams() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// M�todo doGet para listar parametros na tela
		PrintWriter output = response.getWriter();
		output.write("<html><body>");
		output.write("Os par�metros recebidos por essa requisi��o s�o: <br>");
		// Utilizando Enum e m�todo request.getParameterNames() para armazenar os nomes
		Enumeration<String> nameParams = request.getParameterNames();
		// O m�todo hasMoreElements() indica se h� elementos n�o varridos na cole��o
		while (nameParams.hasMoreElements()) {
			// O m�todo nextElement retorna o pr�ximo elemento da cole��o
			// Como nextElement retorna um objeto, ent�o toString � usado para converter em String
			output.write(nameParams.nextElement().toString());
			output.write(", ");
		}
		
		output.write("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
