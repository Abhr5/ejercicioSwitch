import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class SistemaAdopcion {

    private final List<Persona> personasRegistradas;
    private final List<Perro> perrosDisponibles;
    private final Scanner scanner;

    public SistemaAdopcion() {
        personasRegistradas = new ArrayList<>();
        perrosDisponibles = new ArrayList<>();
        perrosDisponibles.add(new Perro("P001", "Fido", "Labrador", 3, "Grande"));
        perrosDisponibles.add(new Perro("P002", "Luna", "Beagle", 2, "Mediano"));
        perrosDisponibles.add(new Perro("P003", "Max", "Chihuahua", 5, "Pequeño"));
        perrosDisponibles.add(new Perro("P004", "Rocky", "Pastor Alemán", 4, "Grande"));

        scanner = new Scanner(System.in);
    }

    public void iniciar() {
        System.out.println("****************************************");
        System.out.println("* BIENVENIDO AL SISTEMA DE ADOPCIÓN DE PERROS *");
        System.out.println("****************************************");
        int opcion;
        do {
            mostrarMenu();
            opcion = leerOpcionUsuario();
            procesarOpcion(opcion);
        } while (opcion != 7);

        System.out.println("\nGracias por usar el Sistema de Adopción. ¡Hasta pronto!");
        scanner.close();
    }

    private void mostrarMenu() {
        System.out.println("\n--- MENÚ PRINCIPAL ---");
        System.out.println("1. Registrar Persona");
        System.out.println("2. Registrar Perro (para adopción)");
        System.out.println("3. Ver Personas Registradas");
        System.out.println("4. Ver Perros Disponibles para Adopción");
        System.out.println("5. Adoptar Perro");
        System.out.println("6. Consultar Perro más Viejo Adoptado por Persona");
        System.out.println("7. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private int leerOpcionUsuario() {
        try {
            int opcion = scanner.nextInt();
            scanner.nextLine();
            return opcion;
        } catch (InputMismatchException e) {
            System.err.println("Error: Por favor, ingrese un número válido.");
            scanner.nextLine();
            return -1;
        }
    }

    private void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                registrarPersona();
                break;
            case 2:
                registrarPerro();
                break;
            case 3:
                verPersonasRegistradas();
                break;
            case 4:
                verPerrosDisponibles();
                break;
            case 5:
                adoptarPerro();
                break;
            case 6:
                consultarPerroMasViejo();
                break;
            case 7:
                break;
            default:
                if (opcion != -1) {
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
                }
        }
        if (opcion != 7 && opcion != -1) {
            System.out.print("\nPresione Enter para continuar...");
            scanner.nextLine();
        }
    }

    private void registrarPersona() {
        System.out.println("\n--- Registrar Nueva Persona ---");
        try {
            String documento = leerTextoNoVacio("Documento: ");
            if (buscarPersonaPorDocumento(documento).isPresent()) {
                System.err.println("Error: Ya existe una persona registrada con ese documento.");
                return;
            }

            String nombre = leerTextoNoVacio("Nombre: ");
            String apellido = leerTextoNoVacio("Apellido: ");
            int edad = leerEnteroPositivo("Edad: ");


            Persona nuevaPersona = new Persona(nombre, apellido, edad, documento);
            personasRegistradas.add(nuevaPersona);
            System.out.println("¡Persona registrada exitosamente!");

        } catch (IllegalArgumentException e) {
            System.err.println("Error al registrar persona: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error inesperado al registrar persona: " + e.getMessage());
        }
    }

    private void registrarPerro() {
        System.out.println("\n--- Registrar Nuevo Perro para Adopción ---");
        try {
            String placa = leerTextoNoVacio("Placa: ");
            if (buscarPerroDisponiblePorPlaca(placa).isPresent() || perroYaAdoptado(placa)) {
                System.err.println("Error: Ya existe un perro registrado (disponible o adoptado) con esa placa.");
                return;
            }

            String nombre = leerTextoNoVacio("Nombre: ");
            String raza = leerTextoNoVacio("Raza: ");
            int edad = leerEnteroPositivo("Edad: ");
            String tamano = leerTextoNoVacio("Tamaño (Pequeño/Mediano/Grande): ");

            Perro nuevoPerro = new Perro(placa, nombre, raza, edad, tamano);
            perrosDisponibles.add(nuevoPerro);
            System.out.println("¡Perro registrado exitosamente y disponible para adopción!");

        } catch (IllegalArgumentException e) {
            System.err.println("Error al registrar perro: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error inesperado al registrar perro: " + e.getMessage());
        }
    }

    private boolean perroYaAdoptado(String placa) {
        for (Persona p : personasRegistradas) {
            for (Perro perroAdoptado : p.getPerrosAdoptados()) {
                if (perroAdoptado.getPlaca().equalsIgnoreCase(placa)) {
                    return true;
                }
            }
        }
        return false;
    }


    private void verPersonasRegistradas() {
        System.out.println("\n--- Personas Registradas ---");
        if (personasRegistradas.isEmpty()) {
            System.out.println("No hay personas registradas en el sistema.");
        } else {
            personasRegistradas.forEach(System.out::println);
        }
    }

    private void verPerrosDisponibles() {
        System.out.println("\n--- Perros Disponibles para Adopción ---");
        if (perrosDisponibles.isEmpty()) {
            System.out.println("¡Felicidades! Todos los perros han encontrado un hogar (o no hay perros registrados).");
        } else {
            perrosDisponibles.forEach(System.out::println);
        }
    }


    private void adoptarPerro() {
        System.out.println("\n--- Adoptar un Perro ---");
        if (personasRegistradas.isEmpty()) {
            System.out.println("No hay personas registradas para adoptar.");
            return;
        }
        if (perrosDisponibles.isEmpty()) {
            System.out.println("No hay perros disponibles para adoptar en este momento.");
            return;
        }


        String docPersona = leerTextoNoVacio("Documento de la persona que adopta: ");
        Optional<Persona> personaOpt = buscarPersonaPorDocumento(docPersona);

        if (personaOpt.isEmpty()) {
            System.err.println("Error: No se encontró una persona con el documento " + docPersona);
            return;
        }
        Persona persona = personaOpt.get();


        if (persona.getPerrosAdoptados().size() >= 3) {
            System.out.println(persona.getNombre() + " ya ha alcanzado el límite de adopciones (3 perros).");
            return;
        }


        System.out.println("\nPerros actualmente disponibles:");
        verPerrosDisponibles();
        String placaPerro = leerTextoNoVacio("\nPlaca del perro a adoptar: ");
        Optional<Perro> perroOpt = buscarPerroDisponiblePorPlaca(placaPerro);

        if (perroOpt.isEmpty()) {
            System.err.println("Error: No se encontró un perro disponible con la placa " + placaPerro);
            return;
        }
        Perro perro = perroOpt.get();

        if (persona.adoptarPerro(perro)) {
            perrosDisponibles.remove(perro);
            System.out.printf("¡Adopción exitosa! %s %s ha adoptado a %s (%s).\n",
                    persona.getNombre(), persona.getApellido(), perro.getNombre(), perro.getPlaca());
        } else {
            System.out.println("La adopción no pudo completarse.");
        }
    }

    private void consultarPerroMasViejo() {
        System.out.println("\n--- Consultar Perro Más Viejo Adoptado ---");
        if (personasRegistradas.isEmpty()) {
            System.out.println("No hay personas registradas para consultar.");
            return;
        }

        String docPersona = leerTextoNoVacio("Documento de la persona: ");
        Optional<Persona> personaOpt = buscarPersonaPorDocumento(docPersona);

        if (personaOpt.isEmpty()) {
            System.err.println("Error: No se encontró una persona con el documento " + docPersona);
            return;
        }

        Persona persona = personaOpt.get();
        Optional<Perro> perroMasViejoOpt = persona.perroMasGrande();

        if (perroMasViejoOpt.isPresent()) {
            System.out.println("El perro más viejo adoptado por " + persona.getNombre() + " es:");
            System.out.println(perroMasViejoOpt.get());
        } else {
            System.out.println(persona.getNombre() + " " + persona.getApellido() + " no ha adoptado ningún perro aún.");
        }
    }

    private String leerTextoNoVacio(String prompt) {
        String input = "";
        while (input.trim().isEmpty()) {
            System.out.print(prompt);
            input = scanner.nextLine();
            if (input.trim().isEmpty()) {
                System.err.println("Este campo no puede estar vacío. Intente de nuevo.");
            }
        }
        return input.trim();
    }

    private int leerEnteroPositivo(String prompt) {
        int valor = -1;
        boolean entradaValida = false;
        while (!entradaValida) {
            System.out.print(prompt);
            try {
                if (scanner.hasNextInt()) {
                    valor = scanner.nextInt();
                    if (valor >= 0) {
                        entradaValida = true;
                    } else {
                        System.err.println("Error: El valor no puede ser negativo. Intente de nuevo.");
                    }
                } else {
                    System.err.println("Error: Debe ingresar un número entero válido. Intente de nuevo.");
                    scanner.next();
                }
            } catch (InputMismatchException e) {
                System.err.println("Error inesperado de entrada. Intente de nuevo.");
                scanner.next();
            } finally {
                if (scanner.hasNextLine()) {
                    scanner.nextLine();
                }
            }
        }
        return valor;
    }

    private Optional<Persona> buscarPersonaPorDocumento(String documento) {
        return personasRegistradas.stream()
                .filter(p -> p.getDocumento().equalsIgnoreCase(documento))
                .findFirst();
    }

    private Optional<Perro> buscarPerroDisponiblePorPlaca(String placa) {
        return perrosDisponibles.stream()
                .filter(p -> p.getPlaca().equalsIgnoreCase(placa))
                .findFirst();
    }

    public static void main(String[] args) {
        SistemaAdopcion sistema = new SistemaAdopcion();
        sistema.iniciar();
    }
}
