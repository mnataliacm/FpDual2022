package edu.fpdual.Ejercicios.objetos_metodos_variables_constructores;

import java.util.Scanner;

public class Saludo {
	public static void main(String[]args) {
	
	System.out.println("Hola " + args[0]);
		
	Scanner s = new Scanner(System.in);
	System.out.print("\nIntroduce una palabra: ");
	String palabra = s.nextLine();
	System.out.println("Hola " + palabra);

	s.close();
	}		
}