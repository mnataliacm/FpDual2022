package Excepciones;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Creo una excepción propia
 *
 * @author Natalia Castillo Muñoz
 */
public class ExcepcionPropia extends Throwable {

	private String texto;

	public ExcepcionPropia(String mensaje) {
		super(mensaje);
		this.texto = mensaje;
	}

	//Creado para ejercicio 9
	ExcepcionPropia() {
		try {
			throw new ErrorEj9("Es menor");
		} catch (ErrorEj9 ex) {
			Logger.getLogger(ExcepcionPropia.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void mostrarMensaje() {
		System.out.println(this.texto);
	}
	private static class ErrorEj9 extends Exception {
		public ErrorEj9(String es_menor) {
		}
	}
}
