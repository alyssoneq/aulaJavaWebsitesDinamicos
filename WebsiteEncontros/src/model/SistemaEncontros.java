package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe respons�vel por listar e registrar encontros
 * Nessa classe foi utilizada o framework collection
 * Para gerenciar os encontros, implementou-se um list interface
 * 
 **/
public class SistemaEncontros {
	// Interface List usada para armazenar os encontros
	private List<Encontro> encontros = new ArrayList<Encontro>();
	
	// M�todo para adicionar encontro � lista
	public void adicionar(Encontro e) {
		encontros.add(e);
	}
	
	//M�todo para listar encontros da lista
	public List<Encontro> listarEncontros() {
		return encontros;
	}
}
