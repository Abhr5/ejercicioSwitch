import java.util.Scanner;
import java.util.Random;
public class apuestaGana {

    public static void main(String[] args) {
        Scanner escaner = new Scanner(System.in);
        Random ran = new Random();

        System.out.println("***Bienvenido al juego de apuestas***");
        System.out.println("Ingrese la cantidad con la que desea ganar:");
        double dinero = escaner.nextDouble();
        boolean seguirJugando = true;


        while (seguirJugando && dinero > 0){
            int resultado = ran.nextInt(3) + 1;
            System.out.println("Su resultado es el número: " + resultado);

            if (resultado == 1){
                dinero *= 2;
                System.out.println("Su dinero se ha multiplicado por 2!!");
                System.out.println("Su nueva cantidad es: " + dinero );
                seguirJugando = solicitarContinuar(escaner);
            } else if (resultado == 2){
                dinero /= 2;
                System.out.println("Lo sentimos :( Perdiste la mitad de tu dinero!!");
                System.out.println("Su nueva cantidad es: " + dinero);
                seguirJugando = solicitarContinuar(escaner);
            } else if (resultado == 3){
                dinero = 0;
                System.out.println("Lo sentimos has perdido!!");
                seguirJugando = false;
            }

        }

    }
private static boolean solicitarContinuar(Scanner escaner) {
    System.out.println("¿Desea seguir jugando? (s/n): ");
    String respuesta = escaner.next();
    return respuesta.equalsIgnoreCase("s");
}

}
