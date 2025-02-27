import java.util.Random;
public class ejercicioDados {
    public static void main(String[] args) {
        Random rand = new Random();
        int numTiradas = 2 + rand.nextInt(99);
        int sumDadoA = 0;
        int sumDadoB = 0;

        for (int i = 0; i < numTiradas; i++) {
            int dadoA = 1 + rand.nextInt(6);
            int dadoB = 1 + rand.nextInt(6);
            sumDadoA += dadoA;
            sumDadoB += dadoB;
            System.out.println("Tirada " + (i + 1) + ": Dado 1 = " + dadoA + ", Dado 2 = " + dadoB);
        }

        System.out.println("Suma total del Dado 1: " + sumDadoA);
        System.out.println("Suma total del Dado 2: " + sumDadoB);


        if (sumDadoA > sumDadoB) {
            System.out.println("El Dado 1 es el ganador.");
        } else if (sumDadoB > sumDadoA) {
            System.out.println("El Dado 2 es el ganador.");
        } else {
            System.out.println("Es un empate.");
        }
    }
}