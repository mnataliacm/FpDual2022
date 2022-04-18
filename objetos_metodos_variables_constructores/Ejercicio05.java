package edu.fpdual.Ejercicios.objetos_metodos_variables_constructores;

public class Ejercicio05 {

	public static void main(String[]args) {
		int conteo = Integer.parseInt(args[1]);
		while (conteo > 0) {
			System.out.println(args[0]);
			conteo--;
		}
	}
}