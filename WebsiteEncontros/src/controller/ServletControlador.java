package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Encontro;
import model.SistemaEncontros;

/**
 * Servlet implementation class ServletControlador
 * Controlador MVC do sistema de encontros
 * Atende requisições tanto por GET ou POST
 * Verifica qual ação requisitada e atua de acordo
 * Possíveis ações do controlador:
 * 	- cadastrar = tela de cadastro
 * 	- confirmarCadastro = constroi objeto Encontro
 * 	- listar = Organiza na tela lista com todos os encontros
 * 	- ação não cadastrada = direciona para o index.html
 * 
 */
@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletControlador() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Resgatando o parâmetro ação da requisição
		String acao = request.getParameter("acao");
		// Referenciando o sistema
		SistemaEncontros sistema = (SistemaEncontros)getServletContext().getAttribute("SISTEMA_ENCONTROS");
		// Criando resposta padrão para caso de ação indeterminada
		String resposta = "index.jsp";
		
		// Loop para determinar qual a ação a executar
		if ("cadastrar".equals(acao)) {
			resposta = "cadastrar.jsp";
		} else if ("confirmarCadastro".equals(acao)) {
			// Instancia de um encontro
			Encontro e = new Encontro();
			// Registrando os atributos passados na requisição
			e.setNomePessoa(request.getParameter("nomePessoa"));
			e.setLocal(request.getParameter("local"));
			e.setData(new Date());
			e.setMotivo(request.getParameter("motivo"));
			// Adicionando o encontro à lista de encontros
			sistema.adicionar(e);
			
			// Atribuindo lista de encontros ao parametro 'lista'
			request.setAttribute("lista", sistema.listarEncontros());
			// Lista de encontros é disposta na tela
			resposta = "listar.jsp";
			
		} else if("listar".equals(acao)) {
			// Tela listando todos os encontros
			request.setAttribute("lista", sistema.listarEncontros());
			resposta = "listar.jsp";
		}
		
		// Direcionando para a tela correspondente à ação
		request.getRequestDispatcher(resposta).forward(request, response);
	}

}
