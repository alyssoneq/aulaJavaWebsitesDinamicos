package todosServlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * Servlet implementation class ServletGetPost
 */
@WebServlet("/ServletGetPost")
public class ServletGetPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SimpleDateFormat onlyDate = new SimpleDateFormat("dd/MM/yyyy");
	private SimpleDateFormat onlyTime = new SimpleDateFormat("hh:mm:ss");
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletGetPost() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Resposta simples para testar método GET
		PrintWriter output = response.getWriter();
		output.write("<html><body> Olá! ");
		output.write("Resposta do método GET <br><br>");
		output.write("Data de hoje: ");
		output.write(onlyDate.format(new Date()));
		output.write("</body></html>");
		output.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Resposta básica para testar método POST
		PrintWriter output = response.getWriter();
		output.write("<html><body> Olá! ");
		output.write("Resposta para método POST <br><br>");
		output.write("Hora atual: ");
		output.write(onlyTime.format(new Date()));
		output.write("</body></html>");
		output.close();
	}

}
