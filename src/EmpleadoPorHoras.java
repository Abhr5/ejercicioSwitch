
public class EmpleadoPorHoras extends Empleado {
    private static final double PAGO_POR_HORA = 98000;
    private int horasTrabajadas;

    public EmpleadoPorHoras(String nombre, int edad, int horasTrabajadas) {
        super(nombre, edad);
        this.horasTrabajadas = horasTrabajadas;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    @Override
    public double calcularSalario() {
        return PAGO_POR_HORA * horasTrabajadas;
    }

    @Override
    public String toString() {
        return super.toString() + ", Tipo: Por Horas, Horas Trabajadas: " + horasTrabajadas
                + ", Pago por Hora: $" + String.format("%,.0f", PAGO_POR_HORA)
                + ", Salario Calculado: $" + String.format("%,.0f", calcularSalario());
    }
}
