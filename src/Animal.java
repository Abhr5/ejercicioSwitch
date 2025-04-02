import java.util.Objects;

public abstract class Animal {

    protected String nombre;
    protected int edad;
    protected TipoAlimentacion tipoAlimentacion;


    public Animal(String nombre, int edad, TipoAlimentacion tipoAlimentacion) {
        this.nombre = nombre;
        this.edad = edad;
        this.tipoAlimentacion = tipoAlimentacion;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public TipoAlimentacion getTipoAlimentacion() {
        return tipoAlimentacion;
    }

    public void setTipoAlimentacion(TipoAlimentacion tipoAlimentacion) {
        this.tipoAlimentacion = tipoAlimentacion;
    }




    public abstract String hacerSonido();


    public String describir() {
        return "Nombre: " + nombre + ", Edad: " + edad + " años, Alimentación: " + tipoAlimentacion.getDescripcion();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return edad == animal.edad && Objects.equals(nombre, animal.nombre) && tipoAlimentacion == animal.tipoAlimentacion;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, edad, tipoAlimentacion);
    }
}