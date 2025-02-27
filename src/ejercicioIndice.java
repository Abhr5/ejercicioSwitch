import java.util.Scanner;
public class ejercicioIndice {
	public static void main(String[] args) {
		Scanner escaner = new Scanner(System.in);

		int peso;
        double estatura, imc;

        System.out.println("Ingrese su peso en kilos:");
        peso = escaner.nextInt();

        System.out.println("Ingrese su estatura en metros:");
        estatura = escaner.nextDouble();

        imc = peso / (estatura * estatura);

        if (imc <= 18.49){
            System.out.println("Su indice de masa corporal es: " + imc + " (bajo peso)");
        } else if (imc <= 24.99) {
            System.out.println("Su indice de masa corporal es: " + imc + " (peso normal)");
        } else if (imc <= 29.99) {
            System.out.println("Su indice de masa corporal es: " + imc + " (sobrepeso)");
        } else if (imc <= 34.99) {
            System.out.println("Su indice de masa corporal es: " + imc + " (obesidad leve)");
        } else if (imc <= 39.99) {
            System.out.println("Su indice de masa corporal es: " + imc + " (obesidad media)");
        } else if (imc >= 40) {
            System.out.println("Su indice de masa corporal es: " + imc + " (obesidad mórbida)");
        }

        escaner.close();
    }
	}
