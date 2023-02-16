package org.lsandoval.anotaciones.ejemplo.procesador;

import org.lsandoval.anotaciones.ejemplo.JsonAtributo;
import org.lsandoval.anotaciones.ejemplo.procesador.exception.JsonSerializadorException;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Collectors;

public class JsonSerializador {

    public static String convertirJson(Object object){

        // Aumentamos manejo de excepciones
        if (object == null){
            throw new JsonSerializadorException("El objeto a serializar no puede ser null");
        }

        Field[] atributos = object.getClass().getDeclaredFields();

        String json = Arrays.stream(atributos)
                            // Del array de atributos solo nos importan los que tengan la anotacion JsonAtributo
                            .filter(f -> f.isAnnotationPresent(JsonAtributo.class))
                            // Transformamos de un objetos Field a String formando el formato de un json
                            .map(f -> {
                                f.setAccessible(true);      // Por defecto como los atributos son private no podemos acceder a estos
                                // Si la anotacion no tiene especificado el nombre(), se le asigna el nombre del atributo
                                String nombre = f.getAnnotation(JsonAtributo.class).nombre().equals("") ? f.getName() : f.getAnnotation(JsonAtributo.class).nombre();

                                try {

                                    // Agregamos la rutina de capitalizacion

                                    // Obtenemos el valor del atributo
                                    Object valor = f.get(object);

                                    // Verificamos si el atributo tiene el metodo capitalizar y si es string
                                    if (f.getAnnotation(JsonAtributo.class).capitalizar() && valor instanceof String){

                                        String nuevoValor = (String) valor;

                                        // split devuelve un array de String, a cada elemento de ese stream,
                                        // convertimos la primera letra en mayuscula y el resto en minuscula
                                        nuevoValor = Arrays.stream(nuevoValor.split(" "))
                                                            .map(palabra -> palabra.substring(0,1).toUpperCase() + palabra.substring(1).toLowerCase())
                                                            .collect(Collectors.joining(" "));

                                        // Seteamos el nuevo valor del atributo al objeto
                                        f.set(object, nuevoValor);
                                    }


                                    // damos formato "nombre:valor", el metodo get del api reflection obtiene el valor del atributo pasando el objeto que examinemos
                                    return "\"" + nombre + "\": \"" + f.get(object) + "\"";
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


        return json;
    }

}
