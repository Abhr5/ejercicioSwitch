
public class LibroImpreso extends Libro {
    private double peso; // en kilogramos (kg)
    public LibroImpreso(String titulo, String autor, double precio, double peso) {
        super(titulo, autor, precio);
        this.peso = peso;
    }


    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        if (peso > 0) {
            this.peso = peso;
        } else {
            System.out.println("Error: El peso debe ser positivo.");
        }
    }


    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.printf("Peso: %.2f kg%n", peso);
    }
}