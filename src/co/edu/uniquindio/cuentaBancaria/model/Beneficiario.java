package co.edu.uniquindio.cuentaBancaria.model;

public class Beneficiario {
	private String nombre;
	private String apellidos;
	private int edad;
	private String identificacion;
	private Restriccion restriccion;
	public Beneficiario(String nombre, String apellidos, int edad, String identificacion) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.identificacion = identificacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identificacion == null) ? 0 : identificacion.hashCode());
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
		Beneficiario other = (Beneficiario) obj;
		if (identificacion == null) {
			if (other.identificacion != null)
				return false;
		} else if (!identificacion.equals(other.identificacion))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Beneficiario [nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad + ", identificacion="
				+ identificacion + "]";
	}

	/**
	 * Parte del codigo para realizar compra por parte del beneficiario
	 * @param costoCompra
	 * @return
	 */
	public boolean determinarRango(double costoCompra) {
		return restriccion.determinarRango(costoCompra);
	}



}
