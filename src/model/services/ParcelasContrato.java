package model.services;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Spliterator;

import model.entities.Contrato;

public class ParcelasContrato {
	
	private Integer numeroParcelas;
	private Double[] valorParcelas;
	private Date[] datasPagamentos;
	
	private TaxasContrato taxasContrato;
	private Contrato contrato;

	public ParcelasContrato() {
	
	}

	public ParcelasContrato(Integer numeroParcelas,TaxasContrato taxasContrato, Contrato contrato) {
		this.numeroParcelas = numeroParcelas;
		//this.valorParcela = valorParcela;
		this.taxasContrato = taxasContrato;
		this.contrato = contrato;
	}

	public Integer getNumeroParcelas() {
		return numeroParcelas;
	}

	public void setNumeroParcelas(Integer numeroParcelas) {
		this.numeroParcelas = numeroParcelas;
	}

	public Double[] getValorParcelas() {
		return valorParcelas;
	}

	public TaxasContrato getTaxasContrato() {
		return taxasContrato;
	}

	public void setTaxasContrato(TaxasContrato taxasContrato) {
		this.taxasContrato = taxasContrato;
	}
	
	public Date[] getDatasPagamentos() {
		return datasPagamentos;
	}

	public void valoresParcelas(Contrato contrato) {		
		int numParcelas = getNumeroParcelas();
		double valorParcelaSemJuros, valorComJurosParcela, valorComJurosMensal;
		Double[] valores = new Double[numParcelas];
		
		valorParcelaSemJuros = contrato.getValorContrato() / numParcelas;
		
		for(int i=0; i<numParcelas;i++) {
			
			valorComJurosParcela = (valorParcelaSemJuros) + (taxasContrato.taxaPagamento(valorParcelaSemJuros) * (i+1) );
			valorComJurosMensal = valorComJurosParcela + taxasContrato.jurosMensal(valorComJurosParcela);
			valores[i] = valorComJurosParcela + valorComJurosMensal;
		}
	
		valorParcelas = valores;
	}
	
	public void datasParcelas(Contrato contrato) {
		Date datainicio = contrato.getDataInicioContrato();
		int numParcelas = getNumeroParcelas();
		Date [] datasParcelas = new Date[numParcelas];
		
		GregorianCalendar calendario = new GregorianCalendar();
		calendario.setTime(datainicio);
		
		for(int i=0;i<numParcelas;i++) {
			calendario.add(calendario.MONTH, i);
			datasParcelas[i]= calendario.getTime();			
		}
		
		this.datasPagamentos = datasParcelas;
	}
}
