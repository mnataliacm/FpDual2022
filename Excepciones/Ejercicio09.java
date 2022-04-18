package Excepciones;
/**
 * Crear comportamiento similar a la reanudación.
 * Usar un bucle que se repita hasta que no haya excepción.
 *
 * @author Natalia Castillo Muñoz
 */
public class Ejercicio09 {

  private static boolean Exc;
  public static void main(String[] args) {
    int edad = 1;
    while (Exc) {
      try {

        if (edad < 18) {
          edad++;
          Exc = false;
          System.out.println("Eres menor, tienes : " + edad);
          throw new ExcepcionPropia();
        } else {
          System.out.println("Acceso Permitido");
          Exc = true;
        }
      } catch (Excepciones.ExcepcionPropia ex) {
        System.out.println("Error propio");
      }
    }
  }
}