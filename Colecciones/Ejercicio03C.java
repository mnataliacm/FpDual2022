package edu.fpdual.Ejercicios.Colecciones;

import edu.fpdual.Ejercicios.Arreglos.NoEsParExcepcion;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio03C {
  public static void main(String[] args) {

    List<Integer> numeros = new ArrayList<Integer>();
    for (int i = 0; i < 7; i++) {
      numeros.add((int) (Math.random() * 6) + 1);
    }
    for (Integer n : numeros) {
      System.out.print(n + " ");
    }

    try {
      centrales(numeros);
    } catch (NoEsParExcepcion e) {
      System.out.println("No se ha podido realizar");
    }
  }

  public static void centrales(List<Integer> n) throws NoEsParExcepcion {

    if (n.size() % 2 != 0) {
      throw new NoEsParExcepcion();
    }

    int[] centro = new int[2];
    int conteo = 0;
    int valor = (n.size() / 2) - 1;
    for (int i = valor; i < valor + 2; i++) {
      centro[conteo++] = n.get(i);
    }
    System.out.println("\nLos valores centrales son: ");
    for (int x: centro) {
      System.out.print(x + " ");
    }
  }
}
