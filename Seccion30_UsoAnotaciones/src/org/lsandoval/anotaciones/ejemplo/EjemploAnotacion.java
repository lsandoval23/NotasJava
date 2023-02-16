package org.lsandoval.anotaciones.ejemplo;

import org.lsandoval.anotaciones.ejemplo.JsonAtributo;
import org.lsandoval.anotaciones.ejemplo.models.Producto;
import org.lsandoval.anotaciones.ejemplo.procesador.JsonSerializador;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.Arrays;

public class EjemploAnotacion {
    public static void main(String[] args) throws IllegalAccessException {
        
        Producto p = new Producto();
        p.setNombre("mesa centro roble");
        p.setFecha(LocalDate.now());
        p.setPrecio(1000L);

        System.out.println("json = " + JsonSerializador.convertirJson(p));


    }
}
