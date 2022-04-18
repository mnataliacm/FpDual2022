package Excepciones;

public class PrimeraExcepcion extends SegundaExcepcion{
  public static void PrimeraExcepcion() throws Exception {
    try {
      SegundaExcepcion();
    } catch (Exception e) {
      throw new Exception("Excepción Primera ", e);
    }
  }
}
