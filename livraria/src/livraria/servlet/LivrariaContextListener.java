package livraria.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import livraria.negocio.Livraria;

/**
 * Classe Listener para gerar o contexto dos servlets
 * Nesse contexto é disponibilizado o sistema 
 * O sistema é disponibilizado para as operações fiquem disponíveis a camada web
 *
 */
@WebListener
public class LivrariaContextListener implements ServletContextListener {
	// Utilização da constante evita a palavra sistemaLivraria em vários locais
	// Isso reduz erros
    public static final String SISTEMA_LIVRARIA = "sistemaLivraria";
	
    // Método de inicialização do contexto dos servlets	
    public void contextInitialized(ServletContextEvent event)  { 
    	ServletContext context = event.getServletContext();

    	// instanciando classe Livraria
        try {
            Livraria livraria = new Livraria();
            context.setAttribute(SISTEMA_LIVRARIA, livraria);
        } catch (Exception ex) {
            System.out.println(
            "O sistema de livraria não pode ser publicado no contexto: "
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
