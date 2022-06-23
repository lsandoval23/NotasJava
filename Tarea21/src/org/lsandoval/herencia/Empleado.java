package org.lsandoval.herencia;

public class Empleado extends Persona {

    private Double remuneracion;
    private Integer empleadoId;


    public Empleado(String nombre, String apellido, String numeroFiscal, String direccion, Double remuneracion, Integer empleadoId) {
        super(nombre, apellido, numeroFiscal, direccion);
        this.remuneracion = remuneracion;
        this.empleadoId = empleadoId;
    }

    public Double getRemuneracion() {
        return remuneracion;
    }
    public void setRemuneracion(Double remuneracion) {
        this.remuneracion = remuneracion;
    }

    public Integer getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(Integer empleadoId) {
        this.empleadoId = empleadoId;
    }



    public void aumentarRemuneracion(int porcentaje){
        this.setRemuneracion(this.remuneracion + (porcentaje*this.remuneracion)/100);
    }

    @Override
    public String toString() {
        return "\tEmpleado{\n" +
                super.toString() +
                "\tremuneracion=" + remuneracion +
                ", empleadoId=" + empleadoId +
                '}'+'\n';
    }
}
