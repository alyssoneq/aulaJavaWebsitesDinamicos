package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletTela2Cadastro
 * 
 * Servlet com tela final mostrando todos os dados digitados ao longo das telas
 * 
 */
@WebServlet("/ServletTela2Cadastro")
public class ServletTela2Cadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletTela2Cadastro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Método doGet executa um doPost
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Método doPost para imprimir na tela todos os dados preenchidos e confirmar cadastro
		PrintWriter output = response.getWriter();
		
		output.write("<html>");
        output.write("<head>");
        output.write("<title>Confirmação de registro</title>");
        output.write("</head>");
        output.write("<body>");
        output.write("<h3>Registro realizado com sucesso!</h3><br/><br/>");
        output.write("<b>Seus dados pessoais:</b><br/>");
        output.write(request.getParameter("nome") + " " + request.getParameter("sobrenome"));
        output.write("<br/>");
        output.write(request.getParameter("rua"));
        output.write("<br/>");
        output.write(request.getParameter("complemento"));
        output.write("<br/>");
        output.write(request.getParameter("cidade"));
        output.write(", ");
        output.write(request.getParameter("cep"));
        output.write(", ");
        output.write(request.getParameter("estado"));
        output.write("<br/>");
        output.write("<b>Seus dados profissionais:</b><br/>");
        output.write(request.getParameter("empresa"));
        output.write("<br/>");
        output.write(request.getParameter("ruaEmpresa"));
        output.write("<br/>");
        output.write(request.getParameter("complementoEmpresa"));
        output.write("<br/>");
        output.write(request.getParameter("cidadeEmpresa"));
        output.write(", ");
        output.write(request.getParameter("cepEmpresa"));
        output.write(", ");
        output.write(request.getParameter("estadoEmpresa"));
        output.write("</body></html>");
		
	}

}
