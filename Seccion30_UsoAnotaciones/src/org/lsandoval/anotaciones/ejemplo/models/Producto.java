package org.lsandoval.anotaciones.ejemplo.models;

import org.lsandoval.anotaciones.ejemplo.JsonAtributo;

import java.time.LocalDate;

public class Producto {

    // Los atributos marcados con la anotacion son los que se pasaran en el json de la clase producto.
    @JsonAtributo
    private String nombre;

    @JsonAtributo
    private Long precio;

    @JsonAtributo
    private LocalDate fecha;




    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
