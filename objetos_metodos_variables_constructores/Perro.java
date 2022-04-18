package edu.fpdual.Ejercicios.objetos_metodos_variables_constructores;

public class Perro extends AnimalesAbstract {
	
	private String colorPelo;
	private String raza;
	private int tamanio;
	
	public Perro (int patas, String pelaje, String especie, String colorPelo, String raza, int tamanio, String tipoComida) {
		super(patas, pelaje, especie);
		this.colorPelo = colorPelo;
		this.raza = raza;
		this.tamanio = tamanio;
		super.tipoComida = tipoComida;
	}
	
	public void correr() {
		System.out.println("Estoy corriendo!! wiiiii");
	}
	
	public void dormir() {
		System.out.println("Estoy durmiendo");
	}
	
	@Override
	public void sonido(){
		System.out.println("Guau Guau");
	}
	
	//@Override
	public static void main(String[]args) {
		Perro perro = new Perro(4, "largo", "canina", "blanco", "Husky", 4, "Pienso");		
		perro.correr();
		perro.dormir();
	}

	@Override
	public void comer() {

	}
}