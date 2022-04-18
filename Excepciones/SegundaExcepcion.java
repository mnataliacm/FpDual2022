package Excepciones;

public class SegundaExcepcion extends TerceraExcepcion{
  public static void SegundaExcepcion() throws Exception {
    try {
      TerceraExcepcion();
    } catch (Exception e) {
      throw new Exception("Excepción Segunda ", e);
    }
  }
}
