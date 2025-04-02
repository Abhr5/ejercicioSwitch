
public class Gato extends Animal implements Mascota {

    public Gato(String nombre, int edad) {

        super(nombre, edad, TipoAlimentacion.CARNIVORO); // Llama al constructor de Animal
    }


    @Override
    public String hacerSonido() {
        return "Miau miau";
    }


    @Override
    public void jugar() {
        System.out.println(nombre + " está persiguiendo un ovillo de lana!");
    }


}