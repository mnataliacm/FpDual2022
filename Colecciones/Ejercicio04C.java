package edu.fpdual.Ejercicios.Colecciones;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ejercicio04C {
  public static void main(String[] args) {

    ArrayList<Integer> numeros = new ArrayList<>();
    for (int i = 0; i < 7; i++) {
      numeros.add((int) (Math.random() * 6) + 1);
    }
    System.out.println("\nEl arreglo es: ");
    for (Integer n : numeros) {
      System.out.print(n + " ");
    }
    voltear(numeros);
  }

  public static void voltear(List n) {
    Collections.reverse(n);
    System.out.println("\nEl arreglo del revés es: ");
    for (Object x : n) {
      System.out.print(x + " ");
    }

  }
}
