package Excepciones;

/**
 * La lanzará el ejercicio 5 metodo f()
 *
 * @author Natalia Castillo Muñoz
 */
public class ExcepcionA extends Throwable{
    public ExcepcionA(String texto) throws ExcepcionA {
        super("Salida ErrorA: " + texto);
    }
}