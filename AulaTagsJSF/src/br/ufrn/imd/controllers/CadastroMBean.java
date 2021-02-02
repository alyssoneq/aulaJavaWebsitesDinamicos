package br.ufrn.imd.controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.ufrn.imd.dominio.Pessoa;

/**
* MBean para realização do cadastro da pessoa. 
* @author itamir.filho 
*/
@ManagedBean 
@SessionScoped 
public class CadastroMBean {

//atributo pessoa
Pessoa pessoa;

/** 
	* Construtor 
*/ 
public CadastroMBean() { 
	pessoa = new Pessoa(); 
} 
  
public Pessoa getPessoa() { 
	return pessoa; 
} 
  
public void setPessoa(Pessoa pessoa) { 
	this.pessoa = pessoa; 
} 
  
/** 
	* Método para realização do cadastro. 
	* @return 
*/ 

public String cadastrar() { 
	return "/sucesso.jsf"; 
} 

}
