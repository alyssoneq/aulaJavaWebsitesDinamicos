package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletTela1Cadastro
 * 
 * Servlet utilizando campos ocultos para repassar parâmetros
 * Essa tela pega valores da tela cadastro.html
 * Em seguida, enviar todos os parâmetros para ServletTela2Cadastro.java 
 * 
 */
@WebServlet("/ServletTela1Cadastro")
public class ServletTela1Cadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletTela1Cadastro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Método para processar um doGet como doPost
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Método POST com repasse de params com campo hidden
		PrintWriter output = response.getWriter();
		
		//Cabeçalho do html gerado 
		
		output.write("<html>");
        output.write("<head>");
        output.write("<title>Dados Profissionais</title>");
        output.write("</head>");
        output.write("<body>");
        output.write("Preencha seus dados profissionais:");
        output.write("<form action=\"ServletTela2Cadastro\">");
		// inserindo os dados enviados do formulário da tela anterior, mas de forma oculta
		output.write("<input type=\"hidden\" name=\"nome\" value=\"");
		output.write(request.getParameter("nome") + "\">");
		output.write("<input type=\"hidden\" name=\"sobrenome\" value=\"");
		output.write(request.getParameter("sobrenome") + "\">");
		output.write("<input type=\"hidden\" name=\"rua\" value=\"");
		output.write(request.getParameter("rua") + "\">");
		output.write("<input type=\"hidden\" name=\"complemento\" value=\"");
		output.write(request.getParameter("complemento") + "\">");
		output.write("<input type=\"hidden\" name=\"cidade\" value=\"");
		output.write(request.getParameter("cidade") + "\">");
		output.write("<input type=\"hidden\" name=\"cep\" value=\"");
		output.write(request.getParameter("cep") + "\">");
		output.write("<input type=\"hidden\" name=\"estado\" value=\"");
		output.write(request.getParameter("estado") + "\">");
		// Dados novos a serem preenchidos pelo usuário
        output.write("Empresa:<input type=\"text\" name=\"empresa\"> <BR>");
        output.write("Endereço profissional:<BR>");
        output.write("Rua: <input type=\"text\" name=\"ruaEmpresa\">");
        output.write("Complemento:<input type=\"text\" name=\"complementoEmpresa\"><BR>");
        output.write("Cidade:<input type=\"text\" name=\"cidadeEmpresa\">");
        output.write("CEP:<input type=\"text\" name=\"cepEmpresa\">");
        output.write("Estado:<input type=\"text\" name=\"estadoEmpresa\"><BR>");
        output.write("<input type=\"submit\" value=\"Confirmar\"><BR>");
        output.write("</form>");
        output.write("</body></html>");
	}

}
