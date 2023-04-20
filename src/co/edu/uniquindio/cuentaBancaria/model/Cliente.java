package co.edu.uniquindio.cuentaBancaria.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	private String nombre;
	private String apellido;
	private String documento;
	private List <CuentaBancaria> listaCuentasBancarias = new ArrayList <CuentaBancaria>();
	private Banco banco;

	public Cliente(String nombre, String apellido, String documento, List<CuentaBancaria> listaCuentasBancarias,
			Banco banco) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.documento = documento;
		this.listaCuentasBancarias = listaCuentasBancarias;
		this.banco = banco;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}


	public List<CuentaBancaria> getListaCuentasBancarias() {
		return listaCuentasBancarias;
	}
	public void setListaCuentasBancarias(List<CuentaBancaria> listaCuentasBancarias) {
		this.listaCuentasBancarias = listaCuentasBancarias;
	}

	public Banco getBanco() {
		return banco;
	}
	public void setBanco(Banco banco) {
		this.banco = banco;
	}
	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", apellido=" + apellido + ", documento=" + documento
				+ ", listaCuentasBancarias=" + listaCuentasBancarias + "]";
	}





}
