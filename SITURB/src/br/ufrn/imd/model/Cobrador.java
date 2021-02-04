package br.ufrn.imd.model; 

/**
	* Classe que representa a entidade cobrador.
	* @author itamir.filho
	*
*/

public class Cobrador {
 
	private String nome;
	 
	private String cpf;
	 
	private String matricula;
	 
	private String endereco;
	 
	public String getNome() {
		return nome;
	}
	 
	public void setNome(String nome) {
		this.nome = nome;
	}
	 
	public String getCpf() {
		return cpf;
	}
	 
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	 
	public String getMatricula() {
		return matricula;
	}
	 
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	 
	public String getEndereco() {
		return endereco;
	}
	 
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	 
	@Override
	public String toString() {
		return nome;
	}

}
