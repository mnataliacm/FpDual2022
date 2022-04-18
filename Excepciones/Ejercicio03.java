package Excepciones;

public class Ejercicio03 {
    public static void main(String[] args) throws ExcepcionPropia {

        throw new ExcepcionPropia("Probando Excepcion Propia");

    }
}

/**
 * si usamos solamente 
 * throw new ExcepcionPropia("Probando Excepcion Propia");
 * da un error y o se añade un try-catch (ejercicio02)
 * o añadimos un throws al metodo y aparece el stacktrace.
 */