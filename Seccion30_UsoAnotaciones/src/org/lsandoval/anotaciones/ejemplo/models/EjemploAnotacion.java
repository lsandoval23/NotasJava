package org.lsandoval.anotaciones.ejemplo.models;

import org.lsandoval.anotaciones.ejemplo.JsonAtributo;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.Arrays;

public class EjemploAnotacion {
    public static void main(String[] args) throws IllegalAccessException {
        
        Producto p = new Producto();
        p.setNombre("mesa centro roble");
        p.setFecha(LocalDate.now());
        p.setPrecio(1000L);

        // Obtenemos los atributos de la clase Producto en un array
        Field[] atributos = p.getClass().getDeclaredFields();

        // Buscamos aquellos atributos que tengan la anotacion y lo procesamos para formar el json
        String json = Arrays.stream(atributos)
                                // Del array de atributos solo nos importan los que tengan la anotacion JsonAtributo
                                .filter(f -> f.isAnnotationPresent(JsonAtributo.class))
                                // Transformamos de un objetos Field a String formando el formato de un json
                                .map(f -> {
                                    f.setAccessible(true);      // Por defecto como los atributos son private no podemos acceder a estos
                                    // Si la anotacion no tiene especificado el nombre(), se le asigna el nombre del atributo
                                    String nombre = f.getAnnotation(JsonAtributo.class).nombre().equals("") ? f.getName() : f.getAnnotation(JsonAtributo.class).nombre();

                                    try {
                                        // damos formato "nombre:valor", el metodo get del api reflection obtiene el valor del atributo pasando el objeto que examinemos
                                        return "\"" + nombre + "\": \"" + f.get(p) + "\"";
                                    } catch (IllegalAccessException e) {
                                        throw new RuntimeException("Error al serializar a json: " + e.getMessage());
                                    }
                                })
                                // Con reduce, concatenamos cada elemento del Stream<String> para forman un solo String
                                .reduce("{", (a,b) -> {
                                    if ("{".equals(a)){
                                        return a + b;
                                    }

                                    return a + ", " + b;
                                })
                                // Le concatenamos al final el cierre del json
                                .concat("}");

        System.out.println("json = " + json);

    }
}
