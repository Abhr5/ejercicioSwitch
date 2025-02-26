import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner escaner = new Scanner(System.in);

        System.out.println("Elige el tipo de Switch:");
        System.out.println("1. Switch clásico");
        System.out.println("2. Switch moderno");
        int eleccion = escaner.nextInt();

        System.out.println("Se presentan a continuación los digítos designados a cada materia, uselos para saber su nota final\n 1. Cálculo integral\n 2. Programación web\n 3. Estructura de datos\n 4. Ingles I\n 5. Química I ");
        int materia = escaner.nextInt();

        if (eleccion == 1){

            double notaFinal = 0;
            switch (materia) {
                case 1:
                    notaFinal = 4.1;
                    System.out.println("Su nota final en Cálculo integral es de: " + notaFinal);
                    break;
                case 2:
                    notaFinal = 4.0;
                    System.out.println("Su nota final en Programación web es de: " + notaFinal);
                    break;
                case 3:
                    notaFinal = 4.4;
                    System.out.println("Su nota final en Estructura de datos es de: " + notaFinal);
                    break;
                case 4:
                    notaFinal = 4.7;
                    System.out.println("Su nota final en Ingles I es de: " + notaFinal);
                    break;
                case 5:
                    notaFinal = 4.2;
                    System.out.println("Su nota final en Química I es de: " + notaFinal);
                    break;
                default:
                    System.out.println("Número invalído");
            }
        } else if (eleccion == 2) {
            double nota = switch (materia) {
                case 1 -> 4.1;
                case 2 -> 4.0;
                case 3 -> 4.4;
                case 4 -> 4.7;
                case 5 -> 4.2;
                default -> -1;
            };

            if (nota != -1) {
                String clase = switch (materia) {
                    case 1 -> "Cálculo diferencial";
                    case 2 -> "Programación web";
                    case 3 -> "Estructura de datos";
                    case 4 -> "Ingles I";
                    case 5 -> "Química I";
                    default -> "Desconocido";
                };
                System.out.println("Su nota en " + clase + " es = " + nota);
            } else {
                System.out.println("Opción inválida.");
            }


            escaner.close();

            
        }


    }
}