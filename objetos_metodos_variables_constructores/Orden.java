package edu.fpdual.Ejercicios.objetos_metodos_variables_constructores;

public class Orden {

	private String id;
	private String fecha;
	private int cantidad;
	private String pedido;
	private static Empleado nombre;
	private static Cliente idCliente;


	public Orden () {
		this.id = id;
		this.fecha = fecha;
		this.cantidad = cantidad;
		this.pedido = pedido;	
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getPedido() {
		return pedido;
	}

	public void setPedido(String pedido) {
		this.pedido = pedido;
	}

	/*public Empleado getNombre() {
		return nombre;
	}*/

	public void setNombre(Empleado nombre) {
		this.nombre = nombre;
	}


	public Cliente getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Cliente idCliente) {
		this.idCliente = idCliente;
	}
	
	

	public Orden(String id, String fecha, int cantidad, String pedido) {
		this.id = id;
		this.fecha = fecha;
		this.cantidad = cantidad;
		this.pedido = pedido;
	}

	public static void main(String[] args) {
		Orden orden1 = new Orden("0010", "22/4/21", 10, "router");
		
		System.out.println("Pedido");
		System.out.println(orden1 + "  Cliente: " + idCliente + "  Empleado: " + nombre);
		
	}
}