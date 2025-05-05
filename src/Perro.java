import java.util.Objects;
public class Perro {
    private final String placa;
    private String nombre;
    private String raza;
    private int edad;
    private String tamano;

    public Perro(String placa, String nombre, String raza, int edad, String tamano) {

        if (placa == null || placa.trim().isEmpty()) {
            throw new IllegalArgumentException("La placa no puede ser nula o vacía.");
        }
        if (edad < 0) {
            throw new IllegalArgumentException("La edad no puede ser negativa.");
        }
        this.placa = placa.trim();
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.tamano = tamano;
    }

    public String getPlaca() {
        return placa;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRaza() {
        return raza;
    }

    public int getEdad() {
        return edad;
    }

    public String getTamano() {
        return tamano;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public void setEdad(int edad) {
        if (edad >= 0) { // Add validation in setter too
            this.edad = edad;
        } else {
            System.err.println("Error: La edad no puede ser negativa.");
        }
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    @Override
    public String toString() {
        return String.format("Perro [Placa: %s, Nombre: %s, Raza: %s, Edad: %d, Tamaño: %s]",
                placa, nombre, raza, edad, tamano);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Perro perro = (Perro) o;
        return placa.equals(perro.placa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(placa);
    }
}
