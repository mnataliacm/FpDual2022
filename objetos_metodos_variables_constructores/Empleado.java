package edu.fpdual.Ejercicios.objetos_metodos_variables_constructores;

public class Empleado {
	String nombre;
	String departamento;
	int telefono;
	String email;
	
	public Empleado (String n, String d, int t, String e) {
		this.nombre = n;
		this.departamento = d;
		this.telefono = t;
		this.email = e;
	}
	
	public void setNombre (String n) {
		this.nombre = n;
	}
	
	public void setDepartamento (String d) {
		this.departamento = d;
	}
	
	public void setTelefono (int t) {
		this.telefono = t;
	}
	
	public void setEmail (String e) {
		this.email = e;
	}
	
	public String toString() {
		String datos = ("\nNombre: " + nombre + 
							"\nDepartamento: " + departamento +
							"\nTelefono: " + telefono +
							"\nEmail: " + email);
		return datos;
	}

	public static void main(String[]args) {

		Empleado emp1 = new Empleado("Alfonso", "RRHH", 555555555, "alfonso@email.com");

		System.out.println("Datos Empleado");
		System.out.println(emp1);
	}
}