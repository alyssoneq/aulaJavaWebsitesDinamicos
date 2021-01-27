package model;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Classe para instanciar e guardar refer�ncia para a classe SistemaEncontros
 * Permite que qualquer Servlet criado possa acessar o sistema
 * Herda o c�digo de uma classe chamada ServletContextListener 
 * 
 **/

// A anota��o @WebListener permite execu��o autom�tica dessa classe ao criar container Servlet
@WebListener
public class ContextListener implements ServletContextListener{
	// Criando constante
	public static final String SISTEMA_ENCONTROS = "sistemaEncontros";
	
	// M�todo invocado quando o container Servlet for criado
	public void contextInitialized(ServletContextEvent event) {
		// Objeto ServletContextEvent permite criar e acessar atributos do ServletContext
		ServletContext context = event.getServletContext();
		// Criando atributo para gerar refer�nciao � classe SistemaEncontros
		context.setAttribute("SISTEMA_ENCONTROS", new SistemaEncontros());		
	}
	
	// M�todo invocado ao destruir um container Servlet
	public void contextDestroyed(ServletContextEvent event) {
		ServletContext context = event.getServletContext();
		// Removendo refer�ncia � classe SistemaEncontros
		context.removeAttribute("SISTEMA_ENCONTROS");
	}
}
