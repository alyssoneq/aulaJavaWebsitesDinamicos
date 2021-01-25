package model;

import java.util.Date;

/**
 * Classe para modelar um encontro
 * Os atributos principais de um encontro são definidos
 * 
 **/

public class Encontro {
	// Definindo as variáveis de negócio
	private String nomePessoa;
	private String local;
	private Date data;
	private String motivo;
	
	// Criando os getters and setters para cada atributo
	public String getNomePessoa() {
		return nomePessoa;
	}
	
	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}
	
	public String getLocal() {
		return local;
	}
	
	public void setLocal(String local) {
		this.local = local;
	}
	
	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
	public String getMotivo() {
		return motivo;
	}
	
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

}
