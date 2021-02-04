package br.ufrn.imd.controllers;
 
import java.util.ArrayList;
import java.util.List;
 
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
 
import br.ufrn.imd.model.Motorista;
 
/**
	* Controller para cadastrar motoristas.
	* @author itamir.filho
	*
*/

@ManagedBean
@SessionScoped

public class CadastrarMotoristaMBean {
 
	private Motorista motorista;
	 
	private List<Motorista> motoristas;
	 
	public CadastrarMotoristaMBean() {
		motorista = new Motorista();
		motoristas = new ArrayList<Motorista>();
	}
	 
	public String entrarCadastro(){
		return "/form_motorista.jsf";
	}
	 
	public String voltar(){
		return "/index.jsf";
	}
	 
	public String cadastrar() {
		motoristas.add(motorista);
		motorista = new Motorista();
		FacesMessage msg = new FacesMessage("Motorista cadastrado com sucesso!");
		msg.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().addMessage("", msg);
		return "/form_motorista.jsf";
	}
	 
	public Motorista getMotorista() {
		return motorista;
	}
	 
	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}
	 
	public List<Motorista> getMotoristas() {
		return motoristas;
	}
	 
	public void setMotoristas(List<Motorista> motoristas) {
		this.motoristas = motoristas;
	}
}