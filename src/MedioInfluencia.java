import java.util.Arrays;
import java.util.Optional;
public enum MedioInfluencia {
    INTERNET("Internet", 700000),
    RADIO("Radio", 200000),
    TELEVISION("Televisión", 600000);

    private final String nombreMostrado;
    private final double costoPorVoto;
    MedioInfluencia(String nombreMostrado, double costoPorVoto) {
        this.nombreMostrado = nombreMostrado;
        this.costoPorVoto = costoPorVoto;
    }

    public String getNombreMostrado() {
        return nombreMostrado;
    }

    public double getCostoPorVoto() {
        return costoPorVoto;
    }

    public static Optional<MedioInfluencia> fromOpcion(int opcion) {
        return Arrays.stream(values())
                .filter(medio -> medio.ordinal() + 1 == opcion) // ordinal() is 0-based
                .findFirst();
    }

    @Override
    public String toString() {
        return nombreMostrado;
    }
}
