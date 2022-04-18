package Excepciones;

public class Ejercicio08 {
    public static void main(String[] args) {
        int n[] = new int[5];

        try {
            n[15]=25;
        }catch (ArrayIndexOutOfBoundsException ae){
            System.out.println("Índice incorrecto");
        }
    }
}
