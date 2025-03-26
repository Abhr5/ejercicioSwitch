class Persona {
    String nombre;
    int edad;


    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }


    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre + ", Edad: " + edad);
    }
}


class Estudiante extends Persona {
    String carrera;


    public Estudiante(String nombre, int edad, String carrera) {
        super(nombre, edad); //
        this.carrera = carrera;
    }


    public void mostrarCarrera() {
        System.out.println(nombre + " estudia " + carrera + ".");
    }
}


public class Main {
    public static void main(String[] args) {
        Persona persona = new Persona("Juan", 40);
        persona.mostrarInformacion();

        Estudiante estudiante = new Estudiante("Ana", 20, "Ingeniería en Sistemas");
        estudiante.mostrarInformacion();
        estudiante.mostrarCarrera();
    }
}