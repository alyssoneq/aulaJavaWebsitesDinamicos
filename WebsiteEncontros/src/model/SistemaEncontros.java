package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por listar e registrar encontros
 * Nessa classe foi utilizada o framework collection
 * Para gerenciar os encontros, implementou-se um list interface
 * 
 **/
public class SistemaEncontros {
	// Interface List usada para armazenar os encontros
	private List<Encontro> encontros = new ArrayList<Encontro>();
	
	// Método para adicionar encontro à lista
	public void adicionar(Encontro e) {
		encontros.add(e);
	}
	
	//Método para listar encontros da lista
	public List<Encontro> listarEncontros() {
		return encontros;
	}
}
