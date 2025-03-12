//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner esc = new Scanner(System.in);

        int numeroLlamadas = 0;
        int duracionTotal  = 0;
        int costoTotal = 0;

        while (true){
            System.out.println("\n1. Registrar llamada");
            System.out.println("2. Mostrar información de la línea");
            System.out.println("3. Reiniciar línea");
            System.out.println("4. Salir");
            System.out.println("Seleccione una opción");
            int opc = esc.nextInt();

            if (opc == 1){
                System.out.println("¿Qué tipo de llamada desea realizar? (Local, Larga Distancia o Celular)");
                String tipo = esc.next().toLowerCase();
                int minutos;

                do {
                System.out.println("Ingrese la duración en minutos");
                minutos = esc.nextInt();
                if (minutos < 0){
                    System.out.println("Error: La duración debe ser positiva");
                }
                } while (minutos < 0);
                int precioMinuto = 0;
                switch (tipo){
                    case "Local" -> {
                        precioMinuto = 50;
                    }
                    case "Larga Distancia" -> {
                        precioMinuto = 350;
                    }
                    case "Celular" -> {
                        precioMinuto = 150;
                    }
                    default -> {
                        System.out.println("");
                    }

                }

                if (precioMinuto > 0) {
                    System.out.println("Tipo de llamada no válido. No se registró su llamada");
                } else{
                    numeroLlamadas++;
                    duracionTotal += minutos;
                    costoTotal = minutos * precioMinuto;

                    System.out.println("Su llamada se ha registrado");
                }

            } else if (opc == 2) {
                System.out.println("\n=====Información de la Línea=====");
                System.out.println("Número de llamadas realizadas: " + numeroLlamadas);
                System.out.println("Duración total de las llamadas realizadas: " + duracionTotal + " minutos");
                System.out.println("Costo total: $" + costoTotal + " pesos");

            } else if (opc == 3) {
                numeroLlamadas = 0;
                duracionTotal = 0;
                costoTotal = 0;
                System.out.println("Ha reiniciado ésta línea");

            } else if (opc == 4) {
                System.out.println("Saliendo...\nNos vemos!!!");
                break;
            } else {
                System.out.println("Opción Inválida");
            }

        }
        esc.close();

    }
}