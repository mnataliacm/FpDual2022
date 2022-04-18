package herencia.Ejercicio02;

class Empleado {
    private String nombre, dni;
    private static int edad;
    private boolean casado;
    private static double salario;

    public Empleado() {
    }

    public Empleado(String nombre, String dni, int edad, boolean casado, double salario) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        this.casado = casado;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public static int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isCasado() {
        return casado;
    }

    public void setCasado(boolean casado) {
        this.casado = casado;
    }

    public static double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Nombre= " + nombre + "."
                + "\nDNI= " + dni + "."
                + "\nCasado= " + casado + "."
                + "\nEdad= " + edad + "."
                + "\nSalario= " + salario + " euros€.\n";
    }

    public static String Clasificacion(int edad) {
        String clase = "";
        if (edad <= 21) {
            clase = "Principiante";
        } else if ((edad >= 22) && (edad <= 35)) {
            clase = "Intermedio";
        } else if (edad > 35) {
            clase = "Senior";
        }
        return clase;
    }

    public static double Salario(double salario, double aumento) {
        int subida = 1;
        subida *= aumento;
        salario += subida;
        return salario;
    }
    
}
