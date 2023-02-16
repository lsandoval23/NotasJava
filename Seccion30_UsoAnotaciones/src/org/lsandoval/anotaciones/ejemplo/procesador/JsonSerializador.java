package org.lsandoval.anotaciones.ejemplo.procesador;

import org.lsandoval.anotaciones.ejemplo.Init;
import org.lsandoval.anotaciones.ejemplo.JsonAtributo;
import org.lsandoval.anotaciones.ejemplo.procesador.exception.JsonSerializadorException;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

public class JsonSerializador {


    public static void inicializarObjeto(Object object){
        if (object == null){
            throw new JsonSerializadorException("El objeto a serializar no puede ser null");
        }

        Method[] metodos = object.getClass().getDeclaredMethods();

        // Se invoca al metodo init() de la clase Producto solo si tiene la anotacion @Init presente, de esta forma
        // se pueden ejecutar diversos metodos de inicializacion antes de pasar al serializar de json
        Arrays.stream(metodos)
                .filter(m -> m.isAnnotationPresent(Init.class))
                .forEach(m -> {
                    m.setAccessible(true);

                    try {
                        // Invocamos aquellos metodos que tengan la anotacion
                        m.invoke(object);
                    } catch (IllegalAccessException | InvocationTargetException e)  {
                        throw new JsonSerializadorException("Error al serializar" + e.getMessage());
                    }


                });


    }

    public static String convertirJson(Object object){

        // Aumentamos manejo de excepciones
        if (object == null){
            throw new JsonSerializadorException("El objeto a serializar no puede ser null");
        }

        // Llamamos a la rutina de inicializar antes de procesar como Json
        inicializarObjeto(object);
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
