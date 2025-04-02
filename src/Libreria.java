/**
 * Clase para demostrar el uso de las clases Libro, LibroImpreso y LibroDigital.
 */
public class Libreria {

    public static void main(String[] args) {
        // Crear un objeto de tipo LibroImpreso
        LibroImpreso libro1 = new LibroImpreso("Cien años de soledad", "Gabriel García Márquez", 25.50, 0.8);

        // Crear un objeto de tipo LibroDigital
        LibroDigital libro2 = new LibroDigital("El código Da Vinci", "Dan Brown", 15.99, 2.5);

        // Crear un libro base (aunque normalmente crearías los tipos específicos)
        Libro libro3 = new Libro("Don Quijote de la Mancha", "Miguel de Cervantes", 10.00);


        System.out.println("Mostrando información del Libro Impreso:");
        libro1.mostrarInfo(); // Llama al mostrarInfo() de LibroImpreso

        System.out.println("\nMostrando información del Libro Digital:");
        libro2.mostrarInfo(); // Llama al mostrarInfo() de LibroDigital

        System.out.println("\nMostrando información del Libro Base:");
        libro3.mostrarInfo(); // Llama al mostrarInfo() de Libro

        System.out.println("\n--- Demostración con Polimorfismo ---");
        // Se pueden tratar objetos LibroImpreso y LibroDigital como si fueran Libro
        Libro miLibroFavorito = new LibroImpreso("El Principito", "Antoine de Saint-Exupéry", 12.00, 0.3);
        miLibroFavorito.mostrarInfo(); // Java sabe que debe llamar al mostrarInfo() de LibroImpreso

        Libro otroLibroDigital = new LibroDigital("1984", "George Orwell", 9.50, 1.8);
        otroLibroDigital.mostrarInfo(); // Java sabe que debe llamar al mostrarInfo() de LibroDigital
    }
}