package Excepciones;

/**
 * Cambio en el ejercicio anterior, envuelva a g() en una excepcion RunTimeException.
 *
 * @author Natalia Castillo Muñoz
 */
public class Ejercicio06 {
  public static void main(String[] args) throws Throwable {

    new Ejercicio05().f();

  }

  public void g() throws ExcepcionB {
    throw new ExcepcionB("Respuesta G");
  }

  public void f() throws ExcepcionA {
    try {
      g();
    } catch (ExcepcionB e) {
      e.printStackTrace();
      throw new ExcepcionA("Respuesta F");
    } catch (RuntimeException re) {
      re.printStackTrace();
      RunTimeException("Error RunTimeException");
    }
  }

  private void RunTimeException(String error_runTimeException) {
  }
}