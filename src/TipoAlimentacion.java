
public enum TipoAlimentacion {
    CARNIVORO("Carnívoro"), // Come carne
    HERBIVORO("Herbívoro"), // Come plantas
    OMNIVORO("Omnívoro");   // Come de todo

    private final String descripcion;


    TipoAlimentacion(String descripcion) {
        this.descripcion = descripcion;
    }


    public String getDescripcion() {
        return descripcion;
    }
}