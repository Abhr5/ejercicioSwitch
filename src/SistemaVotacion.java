import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class SistemaVotacion {

    private final Eleccion eleccion;
    private final Scanner scanner;

    public SistemaVotacion() {
        this.eleccion = new Eleccion();
        this.scanner = new Scanner(System.in);
    }


    public void iniciar() {
        System.out.println("Bienvenido al Sistema de Votación del Municipio 'Premier'");
        int opcion;
        do {
            mostrarMenuPrincipal();
            opcion = leerOpcionUsuario();
            procesarOpcion(opcion);
        } while (opcion != 7);

        System.out.println("Gracias por usar el Sistema de Votación. ¡Hasta pronto!");
        scanner.close();
    }
    private void mostrarMenuPrincipal() {
        System.out.println("\n--- MENÚ PRINCIPAL ---");
        System.out.println("1. Votar por un candidato");
        System.out.println("2. Mostrar costo de campaña por candidato");
        System.out.println("3. Mostrar número total de votos");
        System.out.println("4. Mostrar porcentaje de votos por candidato");
        System.out.println("5. Mostrar costo promedio de campaña");
        System.out.println("6. Vaciar urnas (Reiniciar votación)");
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
                realizarVotacion();
                break;
            case 2:
                mostrarCostosCampana();
                break;
            case 3:
                mostrarTotalVotos();
                break;
            case 4:
                mostrarPorcentajesVotos();
                break;
            case 5:
                mostrarCostoPromedio();
                break;
            case 6:
                confirmarYVaciarUrnas();
                break;
            case 7:
                break;
            default:
                if (opcion != -1) {
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
                }
        }
    }

    private void realizarVotacion() {
        System.out.println("\n--- Registrar Voto ---");
        List<Candidato> candidatos = eleccion.getCandidatos();
        if (candidatos.isEmpty()) {
            System.out.println("No hay candidatos registrados para votar.");
            return;
        }

        System.out.println("Seleccione el candidato:");
        for (int i = 0; i < candidatos.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, candidatos.get(i).getNombre());
        }
        System.out.print("Opción de candidato: ");
        int opcionCandidato = leerOpcionUsuario();
        Optional<Candidato> candidatoOpt = eleccion.getCandidatoPorOpcion(opcionCandidato);

        if (candidatoOpt.isEmpty()) {
            System.err.println("Opción de candidato inválida.");
            return;
        }
        Candidato candidatoSeleccionado = candidatoOpt.get();

        System.out.println("\nSeleccione el medio que influenció su voto:");
        MedioInfluencia[] medios = MedioInfluencia.values();
        for (int i = 0; i < medios.length; i++) {
            System.out.printf("%d. %s\n", i + 1, medios[i].getNombreMostrado());
        }
        System.out.print("Opción de medio: ");
        int opcionMedio = leerOpcionUsuario();
        Optional<MedioInfluencia> medioOpt = MedioInfluencia.fromOpcion(opcionMedio);

        if (medioOpt.isEmpty()) {
            System.err.println("Opción de medio inválida.");
            return;
        }
        MedioInfluencia medioSeleccionado = medioOpt.get();

        eleccion.registrarVoto(candidatoSeleccionado, medioSeleccionado);
        System.out.printf("Voto registrado exitosamente para %s (influenciado por %s).\n",
                candidatoSeleccionado.getNombre(), medioSeleccionado.getNombreMostrado());
    }

    private void mostrarCostosCampana() {
        System.out.println("\n--- Costo de Campaña por Candidato ---");
        List<Candidato> candidatos = eleccion.getCandidatos();
        if (candidatos.isEmpty()) {
            System.out.println("No hay candidatos registrados.");
            return;
        }
        boolean huboVotos = false;
        for (Candidato c : candidatos) {
            double costo = c.calcularCostoCampana();
            System.out.printf("Candidato: %-15s | Costo Campaña: $%,.0f\n", c.getNombre(), costo);
            if (c.getTotalVotos() > 0) huboVotos = true; // Check if anyone has votes
        }
        if (!huboVotos) {
            System.out.println("(Aún no se han registrado votos)");
        }
    }

    private void mostrarTotalVotos() {
        int totalVotos = eleccion.calcularTotalVotosGeneral();
        System.out.println("\n--- Número Total de Votos ---");
        System.out.printf("Total de votos registrados en la elección: %d\n", totalVotos);
    }

    private void mostrarPorcentajesVotos() {
        System.out.println("\n--- Porcentaje de Votos por Candidato ---");
        List<Candidato> candidatos = eleccion.getCandidatos();
        int totalGeneral = eleccion.calcularTotalVotosGeneral();

        if (candidatos.isEmpty()) {
            System.out.println("No hay candidatos registrados.");
            return;
        }
        if (totalGeneral == 0) {
            System.out.println("Aún no se han registrado votos.");
            return;
        }

        for (Candidato c : candidatos) {
            double porcentaje = eleccion.calcularPorcentajeVotos(c);
            System.out.printf("Candidato: %-15s | Votos: %d | Porcentaje: %.2f%%\n",
                    c.getNombre(), c.getTotalVotos(), porcentaje);
        }
        System.out.printf("Total General de Votos: %d\n", totalGeneral);
    }

    private void mostrarCostoPromedio() {
        double costoPromedio = eleccion.calcularCostoPromedioCampana();
        System.out.println("\n--- Costo Promedio de Campaña ---");
        System.out.printf("El costo promedio de campaña por candidato es: $%,.0f\n", costoPromedio);
        if (eleccion.calcularTotalVotosGeneral() == 0) {
            System.out.println("(Basado en 0 votos registrados)");
        }
    }

    private void confirmarYVaciarUrnas() {
        System.out.println("\n--- Vaciar Urnas ---");
        System.out.print("¿Está seguro de que desea eliminar todos los votos y reiniciar la elección? (s/N): ");
        String confirmacion = scanner.nextLine().trim().toLowerCase();
        if (confirmacion.equals("s")) {
            eleccion.vaciarUrnas();
        } else {
            System.out.println("Operación cancelada. Los votos no han sido eliminados.");
        }
    }
    
    public static void main(String[] args) {
        SistemaVotacion sistema = new SistemaVotacion();
        sistema.iniciar();
    }
}
