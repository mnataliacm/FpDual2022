package Excepciones;

/**
 * Creo ExcepcionPropia. Luego creo un constructor que tome un argumento String y lo almacena en su interior.
 * Escribe un método que imprima el resultado. Crea cláulsula try-catch para aplicar.
 *
 * @author Natalia Castillo Muñoz
 */
public class Ejercicio02 {
    public static void main(String[] args) {
        try {
            throw new ExcepcionPropia("Probando excepción propia");
        } catch (ExcepcionPropia ep) {
            ep.mostrarMensaje();
        }
    }
}

/**
 * De este modo capturamos la excepcion propia
 */