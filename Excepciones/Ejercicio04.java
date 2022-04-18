package Excepciones;

/**
 * Definir referencia a objeto e inicializar a null.
 * Intentar llamar a un método a través de la referencia.
 * Después envolver en un try-catch para capturar la excepción.
 *
 * @author Natalia Castillo Muñoz
 */
public class Ejercicio04 {
    public static void main(String[] args) {

        Evaluacion nota = new Evaluacion();
        try {
            calcular(nota);
        } catch (Exception e) {
            System.out.println("Error capturado");
            e.printStackTrace();
        }
    }

    public static void calcular(Evaluacion nota) {
        int n = Integer.parseInt(String.valueOf(nota));
        System.out.println(n);
    }

    private static class Evaluacion {
        public Evaluacion() {
        }
    }
}

