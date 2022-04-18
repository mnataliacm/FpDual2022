package herencia.Ejercicio02;

public class IMPTech extends Empleado{
    public static void main(String[] args) {
        Empleado emp1 = new Empleado ("Natalia Castillo", "22.222.222-B", 45, true, 1234.56);

        System.out.println(emp1);

        System.out.println("Clasificación = " + Clasificacion(Empleado.getEdad()));
        System.out.println();
        //System.out.print(Empleado.Salario(Empleado.salario, args[0]) + "\n");
        System.out.print("Salario + aumento = " + Empleado.Salario(Empleado.getSalario(), 25.5) + "\n");
    }

}
