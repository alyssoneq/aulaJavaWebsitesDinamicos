package br.ufrn.imd.controllers;
 
import java.util.ArrayList;
import java.util.List;
 
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
 
import br.ufrn.imd.model.Cobrador;
import br.ufrn.imd.model.Empresa;
import br.ufrn.imd.model.Linha;
import br.ufrn.imd.model.Motorista;
import br.ufrn.imd.model.Onibus;
 
/**
	* Controller para cadastrar os ônibus.
	* @author itamir.filho
	*
*/
@ManagedBean
@SessionScoped

public class CadastrarOnibusMBean {
 
	private Onibus onibus;	 
	private List<Onibus> listagem;
	 
	public CadastrarOnibusMBean() {
		iniciarValores();
		listagem = new ArrayList<Onibus>();
	}
		 
	private void iniciarValores() {
		onibus = new Onibus();
		onibus.setMotorista(new Motorista());
		onibus.setLinha(new Linha());
		onibus.setEmpresa(new Empresa());
		onibus.setCobrador(new Cobrador());
	}
	 
	public String entrarCadastro(){
		return "/form_onibus.jsf";
	}
	 
	public String listar(){
		return "/list_onibus.jsf";
	}
	 
	public String voltar(){
		return "/index.jsf";
	}
	 
	public String cadastrar() {
		listagem.add(onibus);
		iniciarValores();
		FacesMessage msg = new FacesMessage("Ônibus cadastrado com sucesso!");
		msg.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().addMessage("", msg);
		return "/form_onibus.jsf";
	}
	 
	public Onibus getOnibus() {
		return onibus;
	}
	 
	public void setOnibus(Onibus onibus) {
		this.onibus = onibus;
	}
	 
	public List<Onibus> getListagem() {
		return listagem;
	}
	 
	public void setListagem(List<Onibus> listagem) {
		this.listagem = listagem;
	}

}