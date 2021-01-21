package tools;

/*
 * Classe criada para contar número de acessos a uma página
 * 
 * Todos os métodos foram definidos como static
 * Assim não há necessidade de instanciar um objeto,
 *  
 * */
public class Contador {
	private static int contagem;
	
	// Método para somar contagem para um novo acesso
	public static void novoAcesso() {
		contagem += 1;		
	}
	
	// Método para retornar valor atual da contagem
	public static int getQuantidadeAcessos() {
		return contagem;
	}
}
