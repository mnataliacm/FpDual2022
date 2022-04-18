package herencia.Ejercicio01;

abstract class  Productos {
    
    private String fechaCaducidad;
    private String numeroLote;

    public Productos() {
    }

    public String getFechaCaducidad() {
        return fechaCaducidad;
    }
    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }
    public String getNumeroLote() {
        return numeroLote;
    }
    public void setNumeroLote(String numeroLote) {
        this.numeroLote = numeroLote;
    }
}
