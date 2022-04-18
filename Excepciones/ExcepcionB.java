package Excepciones;

/**
 *
 * @author Natalia Castillo Muñoz
 */
public class ExcepcionB extends Throwable {
    private String mensaje;

    public ExcepcionB(String mensaje) throws ExcepcionB {
        super("Salida ErrorB: " + mensaje);
        this.mensaje = mensaje;
    }
}