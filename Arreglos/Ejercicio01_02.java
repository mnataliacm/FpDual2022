package edu.fpdual.Ejercicios.Arreglos;

public class Ejercicio01_02 {
  public static void main(String[] args) {

    int[] numeros = new int[10];
    for (int i = 0; i < numeros.length; i++) {
      //numeros[i] = (int) (Math.random() * 6) + 1; //comprobar true en ejercicio 1
      numeros[i] = (int) (Math.random() * 26) + 5; // comprobar true en ejercicio 2
    }
    for (int n : numeros) {
      System.out.print(n + " ");
    }
    System.out.println("\n¿Hay un 6 en primera o ultima posición? " + seis(numeros));
    System.out.println("\n¿Hay un 2 o un 3 en arreglo? " + DosTres(numeros));
  }

  public static boolean seis(int[] n) {
    if ((n[0] == 6) || (n[9] == 6)) {
      return true;
    } else {
      return false;
    }
  }

  public static boolean DosTres(int[] n) {
    for (int i = 0; i < n.length; i++) {
      if ((n[i] == 2) || (n[i] == 3)) {
        return true;
      }
    }
    return false;
  }

}
