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
 * Servlet criado para listar os parâmetros recebidos por ele
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
		// Método doGet para listar parametros na tela
		PrintWriter output = response.getWriter();
		output.write("<html><body>");
		output.write("Os parâmetros recebidos por essa requisição são: <br>");
		// Utilizando Enum e método request.getParameterNames() para armazenar os nomes
		Enumeration<String> nameParams = request.getParameterNames();
		// O método hasMoreElements() indica se há elementos não varridos na coleção
		while (nameParams.hasMoreElements()) {
			// O método nextElement retorna o próximo elemento da coleção
			// Como nextElement retorna um objeto, então toString é usado para converter em String
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
