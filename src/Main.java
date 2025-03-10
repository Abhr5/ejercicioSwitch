//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner esc = new Scanner(System.in);
        int opc;

        do {
            System.out.println("Conversor de temperatura");
            System.out.println("Por favor, ingrese una opción: ");
            System.out.println("1.Celsius a Fahrenheit");
            System.out.println("2.Celsius a Kelvin");
            System.out.println("3.Celcius a Rankine");
            System.out.println("4.Celcius a Réaumur");
            System.out.println("5.Fahrenheit a Celsius");
            System.out.println("6.Fahrenheit a Kelvin");
            System.out.println("7.Fahrenheit a Rankine");
            System.out.println("8.Fahrenheit a Réaumur");
            System.out.println("9.Kelvin a Celsius");
            System.out.println("10.Kelvin a Fahrenheit");
            System.out.println("11.Kelvin a Rankine");
            System.out.println("12.Kelvin a Réaumur");
            System.out.println("13.Rankine a Celsius");
            System.out.println("14.Rankine a Fahrenheit");
            System.out.println("15.Rankine a Kelvin");
            System.out.println("16.Salir");

            while (!esc.hasNextInt()){
                System.out.println("Error. Ingrese un número válido");
            }
            opc = esc.nextInt();

            if (opc >= 1 && opc <= 15){
                System.out.println("Ingrese la temperatura a convertir: ");

                while (!esc.hasNextInt()){
                    System.out.println("Error, ingrese un número válido");
                    esc.nextInt();
                }
                double temperatura = esc.nextDouble();

                double conversion = switch (opc){
                    case 1 -> (temperatura * 9/5) + 32;
                    case 2 -> temperatura + 273.15;
                    case 3 -> (temperatura + 273.15) * 9/5;
                    case 4 -> temperatura * 4/5;
                    case 5 -> (temperatura - 32) * 5/9;
                    case 6 -> (temperatura - 32) * 5/9 + 273.15;
                    case 7 -> temperatura + 273.15;
                    case 8 -> (temperatura - 32) * 4/9;
                    case 9 -> temperatura - 273.15;
                    case 10 -> (temperatura - 273.15) * 9/5 + 32;
                    case 11 -> temperatura * 9/5;
                    case 12 -> (temperatura - 273.15) * 4/5;
                    case 13 -> (temperatura - 491.67) * 5/9;
                    case 14 -> temperatura - 459.67;
                    case 15 -> temperatura * 5/9;
                    default -> throw new
                            IllegalStateException("Opción inválida: " + opc);

                };
                 String unidadMedida = switch (opc){
                     case 1, 10, 14 -> "°F";
                     case 2, 6, 9, 15 -> "°K";
                     case 3, 7, 11 -> "°R";
                     case 4, 8, 12 -> "°Re";
                     case 5, 13 -> "°C";
                     default -> "";
                 };
                System.out.println("Resultado: " + conversion + " "+ unidadMedida);
            } else if (opc != 16) {
                System.out.println("Opción inválida. Intente de nuevo.");
            }

            } while(opc !=16);

            System.out.println("Hasta luego!");
            esc.close();

        }





    }

