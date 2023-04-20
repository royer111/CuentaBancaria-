package co.edu.uniquindio.cuentaBancaria.model;

import java.util.ArrayList;
import java.util.List;

public class CuentaBancaria {
	private String nombres ;
	private String apellidos;
	private String numeroCuenta;
	private TipoCuenta tipoCuenta;
	private Double saldo;
	private List <Beneficiario> listaBeneficiarios = new ArrayList <Beneficiario>();

	public CuentaBancaria(String nombres, String apellidos, String numeroCuenta, TipoCuenta tipoCuenta, Double saldo) {
		super();
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.numeroCuenta = numeroCuenta;
		this.tipoCuenta = tipoCuenta;
		this.saldo = saldo;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public TipoCuenta getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(TipoCuenta tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}


	public List<Beneficiario> getListaBeneficiarios() {
		return listaBeneficiarios;
	}

	public void setListaBeneficiarios(List<Beneficiario> listaBeneficiarios) {
		this.listaBeneficiarios = listaBeneficiarios;
	}

	@Override
	public String toString() {
		return "CuentaBancaria [nombres=" + nombres + ", apellidos=" + apellidos + ", numeroCuenta=" + numeroCuenta
				+ ", tipoCuenta=" + tipoCuenta + ", saldo=" + saldo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numeroCuenta == null) ? 0 : numeroCuenta.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CuentaBancaria other = (CuentaBancaria) obj;
		if (numeroCuenta == null) {
			if (other.numeroCuenta != null)
				return false;
		} else if (!numeroCuenta.equals(other.numeroCuenta))
			return false;
		return true;
	}

	private boolean verificarCuenta(String numeroCuenta1) {
		boolean verificado = false;
			if(numeroCuenta.equals(numeroCuenta1)){
				verificado = true;

			}
			return verificado;
	}


	public boolean verificarDinero(double cantidad) {
		boolean verificado = false;
			if(saldo> cantidad){
				verificado = true;
				return verificado;
			}
			return verificado;
		}



	public  double retirarDinero (double cantidadRetiro, String numeroCuenta ){
		boolean verificadoSaldo = verificarDinero(cantidadRetiro);
		boolean verificadoCuenta = verificarCuenta(numeroCuenta);
			if( verificadoSaldo&&verificadoCuenta){
				saldo -=  cantidadRetiro;
			}
			return saldo;
	}

	public double mostrarSaldo (String numeroCuenta)throws Exception{
		double saldo1 = 0;
		boolean verificado = verificarCuenta(numeroCuenta);
			if(verificado){
				saldo1 = saldo;
			}
			else {
				throw new Exception ("La cuenta ingresada no existe");
			}


		return saldo1;
	}

	public void depositarDinero (String numeroCuenta , double cantidadDeposito ){
		boolean verificado = verificarCuenta (numeroCuenta);
			if(verificado){
				saldo += cantidadDeposito;
			}
	}

	public void transferirDinero (Object obj, double cantidadTransferir, String numeroCuenta) throws Exception{
		CuentaBancaria other = (CuentaBancaria) obj;
		boolean verificadoCuenta = verificarCuenta(numeroCuenta);
		boolean verificadoDinero = verificarDinero (cantidadTransferir);
		if(verificadoCuenta && verificadoDinero){
			saldo = retirarDinero(cantidadTransferir, numeroCuenta);
			other.setSaldo(other.getSaldo() + cantidadTransferir);

		}
		else{
			throw new Exception ("Ha habido un error ");
		}
	}

	/**
	 * Parte del codigo para realizar compra por parte de un beneficiario
	 * @param costoCompra
	 * @return
	 */
	public boolean deternimarRango(double costoCompra) {
        boolean cumpleCompra = false;
        for (Beneficiario beneficiario : listaBeneficiarios) {
			if(beneficiario.determinarRango(costoCompra)){
				cumpleCompra = true;
			}
		}
		return cumpleCompra;
	}
	}


