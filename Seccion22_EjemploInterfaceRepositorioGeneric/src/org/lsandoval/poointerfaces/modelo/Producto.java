package org.lsandoval.poointerfaces.modelo;

import java.util.StringJoiner;

public class Producto extends BaseEntity{

    // Atributos
    private String descripcion;
    private Double precio;

    // Constructor
    public Producto(String descripcion, Double precio) {
        super();
        this.descripcion = descripcion;
        this.precio = precio;
    }

    // Getters and setters
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }



    @Override
    public String toString() {
        return "descripción='" + descripcion + '\'' +
                ", precio=" + precio +
                ", id=" + id;
    }
}
