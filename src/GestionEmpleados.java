import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
public class GestionEmpleados {
    private List<Empleado> listaEmpleados;
    private Scanner scanner;

    public GestionEmpleados() {
        listaEmpleados = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion = 0;
        do {
            System.out.println("\n--- MENÚ DE GESTIÓN DE EMPLEADOS ---");
            System.out.println("1. Registrar Empleado de Planta");
            System.out.println("2. Registrar Empleado por Horas");
            System.out.println("3. Mostrar Todos los Empleados");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                if (scanner.hasNextInt()) {
                    opcion = scanner.nextInt();
                } else {
                    System.out.println("Error: Debe ingresar un número. Intente de nuevo.");
                    scanner.next();
                    opcion = 0;
                    continue;
                }
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        registrarEmpleadoPlanta();
                        break;
                    case 2:
                        registrarEmpleadoPorHoras();
                        break;
                    case 3:
                        mostrarTodosLosEmpleados();
                        break;
                    case 4:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error inesperado al leer la opción. Intente de nuevo.");
                scanner.nextLine();
                opcion = 0;
            }

        } while (opcion != 4);

        scanner.close();
    }

    private void registrarEmpleadoPlanta() {
        System.out.println("\n--- Registrar Empleado de Planta ---");
        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.nextLine();
        while (nombre.trim().isEmpty()) {
            System.out.println("El nombre no puede estar vacío. Inténtelo de nuevo.");
            System.out.print("Ingrese el nombre: ");
            nombre = scanner.nextLine();
        }

        int edad = leerEnteroPositivo("Ingrese la edad: ");

        EmpleadoPlanta empleado = new EmpleadoPlanta(nombre, edad);
        listaEmpleados.add(empleado);
        System.out.println("Empleado de planta registrado exitosamente.");
        System.out.println("Salario Fijo Asignado: $" + String.format("%,.0f", empleado.calcularSalario()));
    }


    private void registrarEmpleadoPorHoras() {
        System.out.println("\n--- Registrar Empleado por Horas ---");
        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.nextLine();
        while (nombre.trim().isEmpty()) {
            System.out.println("El nombre no puede estar vacío. Inténtelo de nuevo.");
            System.out.print("Ingrese el nombre: ");
            nombre = scanner.nextLine();
        }

        int edad = leerEnteroPositivo("Ingrese la edad: ");
        int horas = leerEnteroPositivo("Ingrese las horas trabajadas: ");

        EmpleadoPorHoras empleado = new EmpleadoPorHoras(nombre, edad, horas);
        listaEmpleados.add(empleado);
        System.out.println("Empleado por horas registrado exitosamente.");
        System.out.println("Pago por Hora Asignado: $" + String.format("%,.0f", 98000.0)); // Mostrar el valor constante
        System.out.println("Salario Calculado: $" + String.format("%,.0f", empleado.calcularSalario()));
    }

    private void mostrarTodosLosEmpleados() {
        System.out.println("\n--- Listado de Empleados Registrados ---");
        if (listaEmpleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
        } else {
            for (int i = 0; i < listaEmpleados.size(); i++) {
                Empleado emp = listaEmpleados.get(i);
                System.out.println((i + 1) + ". " + emp.toString());
            }
        }
    }

    private int leerEnteroPositivo(String mensaje) {
        int valor = -1;
        boolean entradaValida = false;
        while (!entradaValida) {
            System.out.print(mensaje);
            try {
                if (scanner.hasNextInt()) {
                    valor = scanner.nextInt();
                    if (valor >= 0) {
                        entradaValida = true;
                    } else {
                        System.out.println("Error: El valor no puede ser negativo. Intente de nuevo.");
                    }
                } else {
                    System.out.println("Error: Debe ingresar un número entero válido. Intente de nuevo.");
                    scanner.next();
                }
            } catch (InputMismatchException e) {
                System.out.println("Error inesperado de entrada. Intente de nuevo.");
                scanner.next(); // Limpiar buffer
            } finally {
                if(scanner.hasNextLine()) {
                    scanner.nextLine();
                }
            }
        }
        return valor;
    }

    public static void main(String[] args) {
        System.out.println("Bienvenido al Sistema de Gestión de Empleados");
        GestionEmpleados gestion = new GestionEmpleados();
        gestion.mostrarMenu();
    }
}
