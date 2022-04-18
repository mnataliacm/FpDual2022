package edu.fpdual.Ejercicios.Colecciones;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Ejercicio01_02C {
  public static void main(String[] args) {

    List<Integer> numeros = new ArrayList<Integer>();
    for (int i = 0; i < 10; i++) {
      //numeros.add((int) (Math.random() * 6) + 1); //comprobar true en ejercicio 1
      numeros.add((int)(Math.random() * 26) + 5); // comprobar true en ejercicio 2
    }
    for (int n : numeros) {
      System.out.print(n + " ");
    }
    System.out.println();
    System.out.println("\nHay un 6 en primera y/o ultima posición: " + seis(numeros));
    System.out.println("\nHay un 2 y/o un 3 en arreglo: " + dosTres(numeros));
    //System.out.println(n.containsAll(Arrays.asList(new Integer[]{2, 3}))); //se puede usar en vez del método.

  }
  public static String seis(List n) {
    if (((int) n.get(0) == 6) || ((int) n.get(9) == 6)) {
      return "Si";
    } else {
      return "No";
    }
  }

  public static String dosTres(List n) {

    if (n.containsAll(Arrays.asList(new Integer[]{2, 3}))) {
      return "Si";
    }
    return "No";
  }
}
