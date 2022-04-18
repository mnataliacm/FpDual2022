package Excepciones;

/**
 * Crear clase con 2 métodos, f() y g(). En g() lanzar excepcionB.
 * En f() llamar a g() capturar su excepción y en catch lanzar la excepciónA.
 * Probar en el main.
 *
 * @author Natalia Castillo Muñoz
 */
public class Ejercicio05 {
    public static void main(String[] args) throws ExcepcionA {

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
        }
    }
}
