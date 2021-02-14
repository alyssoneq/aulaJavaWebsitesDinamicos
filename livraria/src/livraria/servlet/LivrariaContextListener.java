package livraria.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import livraria.negocio.Livraria;

/**
 * Classe Listener para gerar o contexto dos servlets
 * Nesse contexto � disponibilizado o sistema 
 * O sistema � disponibilizado para as opera��es fiquem dispon�veis a camada web
 *
 */
@WebListener
public class LivrariaContextListener implements ServletContextListener {
	// Utiliza��o da constante evita a palavra sistemaLivraria em v�rios locais
	// Isso reduz erros
    public static final String SISTEMA_LIVRARIA = "sistemaLivraria";
	
    // M�todo de inicializa��o do contexto dos servlets	
    public void contextInitialized(ServletContextEvent event)  { 
    	ServletContext context = event.getServletContext();

    	// instanciando classe Livraria
        try {
            Livraria livraria = new Livraria();
            context.setAttribute(SISTEMA_LIVRARIA, livraria);
        } catch (Exception ex) {
            System.out.println(
            "O sistema de livraria n�o pode ser publicado no contexto: "
            + ex.getMessage());
        }
    }
    
    public void contextDestroyed(ServletContextEvent event) {
        ServletContext context = event.getServletContext();

        Livraria livraria = (Livraria) context.getAttribute(SISTEMA_LIVRARIA);

        if (livraria != null) {
            livraria.fechar();
        }

        context.removeAttribute(SISTEMA_LIVRARIA);
     }
	
}
