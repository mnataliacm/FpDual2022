package Excepciones;

import java.util.Scanner;

/**
 * Crear una clase con un main que arroje un objeto de clase exception.
 * Asigne al constructor de la excepcion un argumento String.
 * Agregar clausula final e imprimir mensaje para mostrar que ha llegado aquí.
 *
 * @author Natalia Castillo Muñoz
 */
public class Ejercicio01 {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println("Programa que calcula la media de dos números");
        System.out.print("Primer número: ");
        String num1 = s.next();
        System.out.print("Segundo número: ");
        String num2 = s.next();

        try {
            Double media = (Double.parseDouble(num1) + (Double.parseDouble(num2) / 2));
            System.out.println("La media es = " + media);
        } catch (Exception e) {
            System.out.println("Datos incorrectos, no se puede calcular la media");
        } finally {
            System.out.println("Programa cerrado.");
        }
    }
}