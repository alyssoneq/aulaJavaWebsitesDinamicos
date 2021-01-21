package tools;

/*
 * Classe criada para contar n�mero de acessos a uma p�gina
 * 
 * Todos os m�todos foram definidos como static
 * Assim n�o h� necessidade de instanciar um objeto,
 *  
 * */
public class Contador {
	private static int contagem;
	
	// M�todo para somar contagem para um novo acesso
	public static void novoAcesso() {
		contagem += 1;		
	}
	
	// M�todo para retornar valor atual da contagem
	public static int getQuantidadeAcessos() {
		return contagem;
	}
}
