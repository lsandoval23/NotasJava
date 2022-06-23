package org.lsandoval.herencia;

public class Gerente extends  Empleado{

    private Double presupuesto;


    public Gerente(String nombre, String apellido, String numeroFiscal, String direccion, Double remuneracion, Integer empleadoId, Double presupuesto) {
        super(nombre, apellido, numeroFiscal, direccion, remuneracion, empleadoId);
        this.presupuesto = presupuesto;
    }

    public Double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Double presupuesto) {
        this.presupuesto = presupuesto;
    }

    @Override
    public String toString() {
        return "Gerente{\n" +
                super.toString() +
                "presupuesto=" + presupuesto +
                '}';
    }
}
