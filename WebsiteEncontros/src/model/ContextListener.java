package model;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Classe para instanciar e guardar referência para a classe SistemaEncontros
 * Permite que qualquer Servlet criado possa acessar o sistema
 * Herda o código de uma classe chamada ServletContextListener 
 * 
 **/

// A anotação @WebListener permite execução automática dessa classe ao criar container Servlet
@WebListener
public class ContextListener implements ServletContextListener{
	// Criando constante
	public static final String SISTEMA_ENCONTROS = "sistemaEncontros";
	
	// Método invocado quando o container Servlet for criado
	public void contextInitialized(ServletContextEvent event) {
		// Objeto ServletContextEvent permite criar e acessar atributos do ServletContext
		ServletContext context = event.getServletContext();
		// Criando atributo para gerar referênciao à classe SistemaEncontros
		context.setAttribute("SISTEMA_ENCONTROS", new SistemaEncontros());		
	}
	
	// Método invocado ao destruir um container Servlet
	public void contextDestroyed(ServletContextEvent event) {
		ServletContext context = event.getServletContext();
		// Removendo referência à classe SistemaEncontros
		context.removeAttribute("SISTEMA_ENCONTROS");
	}
}
