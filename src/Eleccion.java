import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
public class Eleccion {
    private final List<Candidato> candidatos;
    public Eleccion() {
        this.candidatos = new ArrayList<>();
        this.candidatos.add(new Candidato("Candidato Alfa"));
        this.candidatos.add(new Candidato("Candidato Beta"));
        this.candidatos.add(new Candidato("Candidato Gamma"));
    }
    public List<Candidato> getCandidatos() {
        return Collections.unmodifiableList(candidatos);
    }
    public Optional<Candidato> getCandidatoPorOpcion(int opcion) {
        if (opcion >= 1 && opcion <= candidatos.size()) {
            return Optional.of(candidatos.get(opcion - 1)); // Adjust for 0-based index
        }
        return Optional.empty();
    }
    public void registrarVoto(Candidato candidato, MedioInfluencia medio) {
        if (candidatos.contains(candidato)) {
            candidato.agregarVoto(medio);
        } else {
            System.err.println("Error: El candidato especificado no participa en esta elección.");
        }
    }

    public int calcularTotalVotosGeneral() {
        return candidatos.stream()
                .mapToInt(Candidato::getTotalVotos)
                .sum();
    }
    public double calcularCostoTotalCampanaGeneral() {
        return candidatos.stream()
                .mapToDouble(Candidato::calcularCostoCampana)
                .sum();
    }
    public double calcularCostoPromedioCampana() {
        if (candidatos.isEmpty()) {
            return 0.0;
        }
        return calcularCostoTotalCampanaGeneral() / candidatos.size();
    }
    public double calcularPorcentajeVotos(Candidato candidato) {
        int totalGeneral = calcularTotalVotosGeneral();
        if (totalGeneral == 0) {
            return 0.0;
        }
        return ((double) candidato.getTotalVotos() / totalGeneral) * 100.0;
    }

    public void vaciarUrnas() {
        for (Candidato candidato : candidatos) {
            candidato.reiniciarVotos();
        }
        System.out.println("Todas las urnas han sido vaciadas. La votación se ha reiniciado.");
    }
}
