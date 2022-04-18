package edu.fpdual.Ejercicios.objetos_metodos_variables_constructores;

public abstract class AnimalesAbstract {
	protected int patas;
	protected String pelaje;
	protected String especie;
	protected String tipoComida;
	
	public AnimalesAbstract(int patas, String pelaje, String especie) {
		this.patas = patas;
		this.pelaje = pelaje;
		this.especie = especie;
	}

	public AnimalesAbstract() {

	}

	public void moverse() {
		System.out.println("Se mueve");
	}
	
	public abstract void comer();
	public abstract void sonido();
	
}