import java.util.ArrayList;
import java.util.List;
public class RefugioAnimales {


    private List<Animal> animales;


    public RefugioAnimales() {

        this.animales = new ArrayList<>();
    }

    public void agregarAnimal(Animal animal) {
        if (animal != null) {
            this.animales.add(animal);
            System.out.println(animal.getNombre() + " ha sido agregado al refugio.");
        }
    }

    public void listarAnimales() {
        System.out.println("\n--- Animales en el Refugio ---");
        if (animales.isEmpty()) {
            System.out.println("El refugio está vacío.");
            return;
        }


        for (Animal animal : animales) {
            System.out.println("------------------------------");
            System.out.println(animal.describir());
            System.out.println("   Sonido: " + animal.hacerSonido());

            if (animal instanceof Mascota) {
                Mascota mascota = (Mascota) animal;
                System.out.print("   Acción: ");
                mascota.jugar();
            } else {
                System.out.println("   (Este animal no implementa la interfaz Mascota)");
            }
        }
        System.out.println("------------------------------");
    }

    public static void main(String[] args) {
        RefugioAnimales miRefugio = new RefugioAnimales();
        Animal perro1 = new Perro("Fido", 3, "Labrador");
        Animal gato1 = new Gato("Misu", 2);
        Animal perro2 = new Perro("Luna", 5, "Beagle");


        miRefugio.agregarAnimal(perro1);
        miRefugio.agregarAnimal(gato1);
        miRefugio.agregarAnimal(perro2);
        miRefugio.agregarAnimal(new Gato("Bigotes", 1));
        miRefugio.listarAnimales();

        System.out.println("\n--- Accediendo a datos específicos ---");
        for (Animal a : miRefugio.animales) {
            if (a instanceof Perro) {
                Perro p = (Perro) a;
                System.out.println(p.getNombre() + " es de raza: " + p.getRaza());
            }
        }
    }
}