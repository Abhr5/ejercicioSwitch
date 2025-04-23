
public class Libreria {

    public static void main(String[] args) {
        LibroImpreso libro1 = new LibroImpreso("Cien años de soledad", "Gabriel García Márquez", 25.50, 0.8);
        LibroDigital libro2 = new LibroDigital("El código Da Vinci", "Dan Brown", 15.99, 2.5);
        Libro libro3 = new Libro("Don Quijote de la Mancha", "Miguel de Cervantes", 10.00);


        System.out.println("Mostrando información del Libro Impreso:");
        libro1.mostrarInfo();

        System.out.println("\nMostrando información del Libro Digital:");
        libro2.mostrarInfo();

        System.out.println("\nMostrando información del Libro Base:");
        libro3.mostrarInfo();

        System.out.println("\n--- Demostración con Polimorfismo ---");
        Libro miLibroFavorito = new LibroImpreso("El Principito", "Antoine de Saint-Exupéry", 12.00, 0.3);
        miLibroFavorito.mostrarInfo();

        Libro otroLibroDigital = new LibroDigital("1984", "George Orwell", 9.50, 1.8);
        otroLibroDigital.mostrarInfo(); 
    }
}