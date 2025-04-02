
public class Perro extends Animal implements Mascota {

    private String raza;


    public Perro(String nombre, int edad, String raza) {

        super(nombre, edad, TipoAlimentacion.OMNIVORO); // Llama al constructor de Animal
        this.raza = raza;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }


    @Override
    public String hacerSonido() {
        return "Guau guau!";
    }

    @Override
    public void jugar() {
        System.out.println(nombre + " está buscando la pelota!");
    }


    @Override
    public String describir() {
        return super.describir() + ", Raza: " + raza;
    }
}