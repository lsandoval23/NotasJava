package org.lsandoval.anotaciones.ejemplo.models;

import org.lsandoval.anotaciones.ejemplo.Init;
import org.lsandoval.anotaciones.ejemplo.JsonAtributo;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Producto {

    // Los atributos marcados con la anotacion son los que se pasaran en el json de la clase producto.
    @JsonAtributo(capitalizar = true)
    private String nombre;

    @JsonAtributo(nombre = "costo")
    private Long precio;

    @JsonAtributo
    private LocalDate fecha;

    @Init
    private void init(){
        this.nombre = Arrays.stream(nombre.split(" "))
                            .map(palabra -> palabra.substring(0,1).toUpperCase() + palabra.substring(1).toLowerCase())
                            .collect(Collectors.joining(" "));
    }


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
