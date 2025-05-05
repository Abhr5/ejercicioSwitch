
public class EmpleadoPlanta extends Empleado {
    private static final double SALARIO_FIJO = 2100000;

    public EmpleadoPlanta(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    public double calcularSalario() {
        return SALARIO_FIJO;
    }

    @Override
    public String toString() {
        return super.toString() + ", Tipo: Planta, Salario Fijo: $" + String.format("%,.0f", SALARIO_FIJO);
    }
}
