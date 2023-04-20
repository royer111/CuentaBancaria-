package co.edu.uniquindio.cuentaBancaria.model;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	private String nombre;
	private List <CuentaBancaria> listaCuentasBancarias = new ArrayList <CuentaBancaria>();
	private List <Cliente> listaClientes = new ArrayList <Cliente>();
	private List <Beneficiario> listaBeneficiarios = new ArrayList <Beneficiario>();




	public Banco(String nombre, List<CuentaBancaria> listaCuentasBancarias, List<Cliente> listaClientes,List<Beneficiario> listaBeneficiarios) {
		super();
		this.nombre = nombre;
		this.listaCuentasBancarias = listaCuentasBancarias;
		this.listaClientes = listaClientes;
		this.listaBeneficiarios = listaBeneficiarios;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public List<CuentaBancaria> getListaCuentasBancarias() {
		return listaCuentasBancarias;
	}



	public void setListaCuentasBancarias(List<CuentaBancaria> listaCuentasBancarias) {
		this.listaCuentasBancarias = listaCuentasBancarias;
	}



	public List<Cliente> getListaClientes() {
		return listaClientes;
	}



	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}



	public List<Beneficiario> getListaBeneficiarios() {
		return listaBeneficiarios;
	}



	public void setListaBeneficiarios(List<Beneficiario> listaBeneficiarios) {
		this.listaBeneficiarios = listaBeneficiarios;
	}



	private boolean verificarCuenta(String numeroCuenta) {
		boolean verificado = false;
		for (CuentaBancaria cuentaaux : listaCuentasBancarias) {
			if(cuentaaux.getNumeroCuenta().equals(numeroCuenta)){
				verificado = true;
				return verificado;
			}
		}
		return verificado;
	}


	public double mostrarSaldo (String numeroCuenta)throws Exception{
		double saldo = 0;
		boolean verificado = verificarCuenta(numeroCuenta);
		for (CuentaBancaria cuentaBancaria : listaCuentasBancarias) {
			if(verificado){
				saldo = cuentaBancaria.getSaldo();
			}
			else {
				throw new Exception ("La cuenta ingresada no existe");
			}

		}
		return saldo;

	}


	public void depositarDinero (String numeroCuenta , double cantidadDeposito ){
		boolean verificado = verificarCuenta (numeroCuenta);
		double saldoActual = 0 ;
		for (CuentaBancaria cuentaBancaria : listaCuentasBancarias) {
			if(verificado){
				saldoActual = cuentaBancaria.getSaldo();
				cuentaBancaria.setSaldo(saldoActual + cantidadDeposito);
			}

		}
	}

	public boolean verificarDinero(double cantidad) {
		boolean verificado = false;
		for (CuentaBancaria cuentaaux : listaCuentasBancarias) {
			if(cuentaaux.getSaldo()> cantidad){
				verificado = true;
				return verificado;
			}
		}
		return verificado;
	}


	public  void retirarDinero1 ( String numeroCuenta, double cantidadRetiro){
		boolean verificado = verificarCuenta(numeroCuenta);
		boolean dinero = verificarDinero(cantidadRetiro);
		for (CuentaBancaria cuentaBancaria : listaCuentasBancarias) {
			if(verificado && dinero ){
				cuentaBancaria.setSaldo(cuentaBancaria.getSaldo() - cantidadRetiro);
			}

		}
	}


/**
	public  void retirarDinero (String numeroCuenta , double cantidadRetiro ){
		boolean verificado = verificarCuenta (numeroCuenta);
		double saldoActual = 0 ;
		boolean verificadoSaldo = verificarDinero(cantidadRetiro);
		for (CuentaBancaria cuentaBancaria : listaCuentasBancarias) {
			if(verificado && verificadoSaldo){
				saldoActual = cuentaBancaria.getSaldo();
				cuentaBancaria.setSaldo(saldoActual - cantidadRetiro);
			}

		}
	}
**/

	public boolean compararCuenta(Object obj) {
		boolean verificado = false;
		CuentaBancaria other = (CuentaBancaria) obj;
		for (CuentaBancaria cuentaaux : listaCuentasBancarias) {
			if(cuentaaux.getSaldo() > other.getSaldo()){
				verificado = true;

			}
		}
		return verificado;
	}

	public void transferirDinero (Object obj, double cantidadTransferir){
		CuentaBancaria other = (CuentaBancaria) obj;
		for (CuentaBancaria cuentaaux : listaCuentasBancarias) {
			String numeroCuenta = cuentaaux.getNumeroCuenta();
			retirarDinero1(numeroCuenta, cantidadTransferir);
			other.setSaldo(other.getSaldo() + cantidadTransferir);
		}
	}

	public String hacerCompraBeneficiario(double costoCompra){
		String mensaje = "";
		for (CuentaBancaria cuentaBancaria : listaCuentasBancarias) {
			if(cuentaBancaria.deternimarRango(costoCompra)){
				cuentaBancaria.setSaldo(cuentaBancaria.getSaldo()-costoCompra);
				mensaje="Compra realizada";
			}
			else{
				mensaje="Lo sentimos, ha habido un error";
			}
		}
		return mensaje;
	}



}
