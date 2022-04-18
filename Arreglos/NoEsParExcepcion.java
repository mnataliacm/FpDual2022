package edu.fpdual.Ejercicios.Arreglos;

public class NoEsParExcepcion extends Throwable{
  public NoEsParExcepcion() {
    System.out.println("\nLa longitud del arreglo no es par");
  }
}
