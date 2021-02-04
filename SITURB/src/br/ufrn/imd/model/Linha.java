package br.ufrn.imd.model;
 
/**
	* Classe que representa uma linha de ônibus.
	* @author itamir.filho
	*/
public class Linha {
 
	private String ident;	 
	private String origem;	 
	private String destino;	 
	private String horaSaida;	 
	private String horaChegada;
	 
	public String getOrigem() {
		return origem;
	}
	 
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	 
	public String getDestino() {
		return destino;
	}
	 
	public void setDestino(String destino) {
		this.destino = destino;
	}
	 
	public String getHoraSaida() {
		return horaSaida;
	}
	 
	public void setHoraSaida(String horaSaida) {
		this.horaSaida = horaSaida;
	}
	 
	public String getHoraChegada() {
		return horaChegada;
	}
	 
	public void setHoraChegada(String horaChegada) {
		this.horaChegada = horaChegada;
	}
	 
	public String getIdent() {
		return ident;
	}
	 
	public void setIdent(String ident) {
		this.ident = ident;
	}
	 
	@Override
	public String toString() {
		return ident;
	}

}