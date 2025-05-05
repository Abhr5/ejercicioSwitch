import java.util.EnumMap;
import java.util.Map;
public class Candidato {
    private final String nombre;
    private final Map<MedioInfluencia, Integer> votosPorMedio;
    public Candidato(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del candidato no puede ser nulo o vacío.");
        }
        this.nombre = nombre;
        this.votosPorMedio = new EnumMap<>(MedioInfluencia.class);
        for (MedioInfluencia medio : MedioInfluencia.values()) {
            this.votosPorMedio.put(medio, 0);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarVoto(MedioInfluencia medio) {
        this.votosPorMedio.compute(medio, (m, count) -> (count == null) ? 1 : count + 1);
    }

    public int getVotosPorMedio(MedioInfluencia medio) {
        return this.votosPorMedio.getOrDefault(medio, 0);
    }

    public int getTotalVotos() {
        return this.votosPorMedio.values().stream().mapToInt(Integer::intValue).sum();
    }

    public double calcularCostoCampana() {
        double costoTotal = 0.0;
        for (Map.Entry<MedioInfluencia, Integer> entry : this.votosPorMedio.entrySet()) {
            MedioInfluencia medio = entry.getKey();
            int numeroVotos = entry.getValue();
            costoTotal += numeroVotos * medio.getCostoPorVoto();
        }
        return costoTotal;
    }

    public void reiniciarVotos() {
        for (MedioInfluencia medio : MedioInfluencia.values()) {
            this.votosPorMedio.put(medio, 0);
        }
    }

    @Override
    public String toString() {
        return nombre;
    }
}
