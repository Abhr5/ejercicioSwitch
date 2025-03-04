import java.util.Random;
import java.util.Scanner;

public class calculadora {

    public static void main(String[] args) {
        Scanner escaner = new Scanner(System.in);
        Random ran = new Random();
        boolean seguirCalculando = true;
        System.out.println("¡Bienvenido a la Calculadora!");
        System.out.println("Operadores disponibles: +, -, *, /, ^, %");

        while (seguirCalculando) {
            int numero1 = ran.nextInt(100) + 1;
            int numero2 = ran.nextInt(100) + 1;
            System.out.println("Número 1: " + numero1);
            System.out.println("Número 2: " + numero2);
            System.out.print("Introduce un signo aritmético (+, -, *, /, ^, %): ");
            String signo = escaner.next();
            double resultado = 0;
            boolean operacionValida = true;

            switch (signo) {
                case "+":
                    resultado = numero1 + numero2;
                    break;
                case "-":
                    resultado = numero1 - numero2;
                    break;
                case "*":
                    resultado = numero1 * numero2;
                    break;
                case "/":
                    if (numero2 != 0) {
                        resultado = (double) numero1 / numero2;
                    } else {
                        System.out.println("Error: No se puede dividir entre 0.");
                        operacionValida = false;
                    }
                    break;
                case "^":
                    resultado = Math.pow(numero1, numero2);
                    break;
                case "%":
                    if (numero2 != 0) {
                        resultado = numero1 % numero2;
                    } else {
                        System.out.println("Error: No se puede usar módulo con divisor 0.");
                        operacionValida = false;
                    }
                    break;
                default:
                    System.out.println("Operador no válido. Por favor, introduce uno válido (+, -, *, /, ^, %).");
                    operacionValida = false;
                    break;
            }
            
            if (operacionValida) {
                System.out.println("Resultado: " + resultado);
            }

            
            System.out.print("¿Deseas realizar otra operación? (s/n): ");
            String respuesta = escaner.next();
            if (!respuesta.equalsIgnoreCase("s")) {
                seguirCalculando = false;
                System.out.println("Gracias por usar la Calculadora. ¡Hasta luego!");
            }
        }

        escaner.close();
    }
}
