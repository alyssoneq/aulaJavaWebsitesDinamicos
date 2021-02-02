package br.ufrn.imd.dominio;

import java.util.Date;

/** 
* Classe simplificada que representa uma pessoa.
* @author itamir.filho
*/ 
public class Pessoa {

private String nome; 
private String endereco;
private Date dataNascimento; 
private String sexo; 
 
public String getNome() {
	return nome; 
}

public void setNome(String nome) { 
	this.nome = nome; 
} 

public String getEndereco() {
	return endereco; 
} 

public void setEndereco(String endereco) { 
	this.endereco = endereco; 
} 

public Date getDataNascimento() { 
	return dataNascimento; 
} 

public void setDataNascimento(Date dataNascimento) { 
	this.dataNascimento = dataNascimento; 
} 

public String getSexo() { 
	return sexo; 
} 

public void setSexo(String sexo) { 
	this.sexo = sexo; 
} 

}
