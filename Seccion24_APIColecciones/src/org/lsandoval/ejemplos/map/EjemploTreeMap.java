package org.lsandoval.ejemplos.map;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class EjemploTreeMap {

    public static void main(String[] args) {

        // El treeMap es similar al hashmap, es un conjunto key-value, pero en este caso se tiene un orden
        // En base a las reglas de ordenamiento que se tengan para la clase de la llave
        Map<String, Object> persona = new TreeMap<>(Comparator.comparing(String::length).reversed());

        persona.put("nombre", "John");
        persona.put("apellido", "Doe");
        persona.put("apellidoPaterno", "Doe");
        persona.put("email", "john.doe@email.com");
        persona.put("edad", 30);

        Map<String, String> direccion = new TreeMap<>();
        direccion.put("pais", "USA");
        direccion.put("estado", "California");
        direccion.put("ciudad", "Santa Barbara");
        direccion.put("calle", "One Street");
        direccion.put("numero", "120");

        persona.put("direccion", direccion);
        System.out.println("persona = " + persona);

    }
}
