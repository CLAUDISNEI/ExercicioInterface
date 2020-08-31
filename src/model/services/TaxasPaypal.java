package model.services;

public class TaxasPaypal implements TaxasContrato {
	
	public double jurosMensal(double valor) {
		return valor * 0.01;
	}
	
	public double taxaPagamento(double valor) {
		return valor * 0.02;
	}

}
