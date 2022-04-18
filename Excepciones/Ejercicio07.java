package Excepciones;

/**
 * Crear 3 excepciones (Primera, Segunda y Tercera). Escribir un método que lance las tres.
 * En el main llame al método pero solo use un catch que detectará las 3 excepciones.
 *
 * @author Natalia Castillo Muñoz
 */
public class Ejercicio07 extends PrimeraExcepcion{
  public static void main(String[] args) {

    try {
      PrimeraExcepcion();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
