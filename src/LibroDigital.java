
public class LibroDigital extends Libro {

    private double tamanioArchivo; // en Megabytes (MB)
    public LibroDigital(String titulo, String autor, double precio, double tamanioArchivo) {
        super(titulo, autor, precio);
        this.tamanioArchivo = tamanioArchivo;
    }


    public double getTamanioArchivo() {
        return tamanioArchivo;
    }

    public void setTamanioArchivo(double tamanioArchivo) {
        if (tamanioArchivo > 0) {
            this.tamanioArchivo = tamanioArchivo;
        } else {
            System.out.println("Error: El tamaño del archivo debe ser positivo.");
        }
    }


    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.printf("Tamaño Archivo: %.2f MB%n", tamanioArchivo);
    }
}