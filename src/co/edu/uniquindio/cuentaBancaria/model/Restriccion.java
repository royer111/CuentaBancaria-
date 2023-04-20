package co.edu.uniquindio.cuentaBancaria.model;

import java.util.ArrayList;
import java.util.List;

public class Restriccion {
	private Double rangoInferior;
	private Double rangoSuperior;
	private List <Beneficiario> listaBeneficiarios = new ArrayList <Beneficiario>();
	public Restriccion(Double rangoInferior, Double rangoSuperior) {
		super();
		this.rangoInferior = 0.0;
		this.rangoSuperior = rangoSuperior;
	}
	public Double getRangoInferior() {
		return rangoInferior;
	}
	public void setRangoInferior(Double rangoInferior) {
		this.rangoInferior = rangoInferior;
	}
	public Double getRangoSuperior() {
		return rangoSuperior;
	}
	public void setRangoSuperior(Double rangoSuperior) {
		this.rangoSuperior = rangoSuperior;
	}

	public List<Beneficiario> getListaBeneficiarios() {
		return listaBeneficiarios;
	}
	public void setListaBeneficiarios(List<Beneficiario> listaBeneficiarios) {
		this.listaBeneficiarios = listaBeneficiarios;
	}
	public boolean determinarRango(double costoCompra){
		boolean cumpleCompra = false;
		for (Beneficiario beneficiario : listaBeneficiarios) {
			if(beneficiario.getEdad()>18 && costoCompra<1000000.0){
				cumpleCompra = true;
			}
			else{
				cumpleCompra= false;
}
		}
		return cumpleCompra;
	}
}
