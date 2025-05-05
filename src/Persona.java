import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
public class Persona {
    private static final int MAX_PERROS_ADOPTADOS = 3;
    private String nombre;
    private String apellido;
    private int edad;
    private final String documento; // Unique identifier, make it final
    private final List<Perro> perrosAdoptados;

    public Persona(String nombre, String apellido, int edad, String documento) {
        if (documento == null || documento.trim().isEmpty()) {
            throw new IllegalArgumentException("El documento no puede ser nulo o vacío.");
        }
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío.");
        }
        if (edad < 0) {
            throw new IllegalArgumentException("La edad no puede ser negativa.");
        }
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.documento = documento.trim();
        this.perrosAdoptados = new ArrayList<>();
}

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public String getDocumento() {
        return documento;
    }

    public List<Perro> getPerrosAdoptados() {
        return List.copyOf(perrosAdoptados);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(int edad) {
        if (edad >= 0) {
            this.edad = edad;
        } else {
            System.err.println("Error: La edad no puede ser negativa.");
        }
    }

    public boolean adoptarPerro(Perro perro) {
        if (perro == null) {
            System.err.println("Error: No se puede adoptar un perro nulo.");
            return false;
        }
        if (perrosAdoptados.size() < MAX_PERROS_ADOPTADOS) {
            if (!perrosAdoptados.contains(perro)) {
                perrosAdoptados.add(perro);
                return true;
            } else {
                System.err.println("Error: Esta persona ya adoptó a este perro (" + perro.getPlaca() + ").");
                return false;
            }
        } else {
            System.out.println(nombre + " ya ha alcanzado el límite de " + MAX_PERROS_ADOPTADOS + " perros adoptados.");
            return false;
        }
    }

    public Optional<Perro> perroMasGrande() {
        return perrosAdoptados.stream()
                .max(Comparator.comparingInt(Perro::getEdad));
    }


    @Override
    public String toString() {
        String perrosStr = perrosAdoptados.isEmpty()
                ? "Ninguno"
                : "\n    - " + perrosAdoptados.stream()
                .map(Perro::toString)
                .collect(Collectors.joining("\n    - "));

        return String.format("Persona [Nombre: %s %s, Edad: %d, Documento: %s]\n  Perros Adoptados (%d/%d): %s",
                nombre, apellido, edad, documento, perrosAdoptados.size(), MAX_PERROS_ADOPTADOS, perrosStr);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return documento.equals(persona.documento);
    }


    @Override
    public int hashCode() {
        return Objects.hash(documento);
    }
}
