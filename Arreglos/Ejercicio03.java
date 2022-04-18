package edu.fpdual.Ejercicios.Arreglos;

public class Ejercicio03 {
  public static void main(String[] args) {

    int[] numeros = new int[6];
    for (int i = 0; i < numeros.length; i++) {
      numeros[i] = (int) (Math.random() * 6) + 1;
    }
    for (int n : numeros) {
      System.out.print(n + " ");
    }

    try {
      centrales(numeros);
    } catch (NoEsParExcepcion e) {
      System.out.println("No se ha podido realizar");
    }
  }

  public static void centrales(int[] n) throws NoEsParExcepcion {
    if ((n.length) % 2 != 0) {
      throw new NoEsParExcepcion();
    }

    int[] centro = new int[2];
    int conteo = 0;
    int valor = (n.length / 2) - 1;
    for (int i = valor; i < valor + 2; i++) {
      centro[conteo++] = n[i];
    }
    System.out.println("\nLos valores centrales son: ");
    for (int x: centro) {
      System.out.print(x + " ");
    }
  }
}
