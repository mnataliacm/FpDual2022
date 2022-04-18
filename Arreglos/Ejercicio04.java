package edu.fpdual.Ejercicios.Arreglos;

public class Ejercicio04 {
  public static void main(String[] args) {

    int[] numeros = new int[12];
    for (int i = 0; i < numeros.length; i++) {
      numeros[i] = (int) (Math.random() * 25) + 1;
      System.out.print(numeros[i] + " ");
    }

    System.out.println("\nArreglo trás voltear números: ");
    voltear(numeros);
  }

  public static void voltear(int[] n) {
    int [] r = new int[n.length];
    for (int i = n.length - 1, conteo = 0; i >= 0; i--, conteo++) {
      r[conteo] = n[i];
      System.out.print(r[conteo] + " ");
    }
  }
}
