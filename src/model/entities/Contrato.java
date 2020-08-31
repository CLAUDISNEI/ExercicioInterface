package model.entities;

import java.util.Date;

public class Contrato {
	
	private Integer numContrato;
	private Double valorContrato;
	private Date	dataInicioContrato;
	
	public Contrato() {
	
	}

	public Contrato(Integer numContrato, Double valorContrato, Date dataInicio) {
		this.numContrato = numContrato;
		this.valorContrato = valorContrato;
		this.dataInicioContrato = dataInicio;
	}

	public Integer getNumContrato() {
		return numContrato;
	}
/*
	public void setNumContrato(Integer numContrato) {
		this.numContrato = numContrato;
	}
*/
	public Double getValorContrato() {
		return valorContrato;
	}
/*
	public void setValorContrato(Double valorContrato) {
		this.valorContrato = valorContrato;
	}
*/
	public Date getDataInicioContrato() {
		return dataInicioContrato;
	}
	/*
	public void setDataInicioContrato(Date dataInicioContrato) {
		this.dataInicioContrato = dataInicioContrato;
	}
	*/
	
	
	
	
	
}
