package edu.fpdual.Ejercicios.objetos_metodos_variables_constructores;


public class Cliente {
	private String idCliente;
	private String nombre;
	private String apellido;
	private String direccion;
	private int telefono;
	private String email;
	
	public Cliente() {
	}

	public Cliente(String idCliente, String nombre, String apellido, String direccion, int telefono, String email) {
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String Datos() {
		String datos = " Nombre: " + this.nombre
						+ "\nApellido: " + this.apellido
						+ "\nDireccion: " + this.direccion
						+ "\nTelefono: " + this.telefono;
		return datos;
	}

	public String toString() {
		String datos = " Nombre: " + this.nombre
				+ "\nApellido: " + this.apellido
				+ "\nDireccion: " + this.direccion
				+ "\nTelefono: " + this.telefono;
		return datos;
	}

	public static void main(String[]args) {
		
		Cliente cli1 = new Cliente("C1", "Natalia", "Castillo", "Avd Andalucia s/n", 333333333, "natalia@email.com");
		
		System.out.println("Datos Cliente");
		System.out.println(cli1);
	}
}