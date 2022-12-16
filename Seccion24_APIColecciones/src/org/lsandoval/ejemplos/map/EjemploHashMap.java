package org.lsandoval.ejemplos.map;

import java.util.*;

public class EjemploHashMap {
    public static void main(String[] args) {

        // Acepta dos parametros genericos, la llave y el valor
        // El segundo parametro generico se setea como object para poder asignarle un hashmap como atributo
        Map<String, Object> persona = new HashMap<>();

        // Para comparar llaves usa la implementacion del metodo equals and hashcode, no pueden existir llaves iguales
        // Se toma el último agregado
        persona.put(null, "1234");      // Acepta llaves o valores null
        persona.put("nombre", "Jhon");
        persona.put("apellido", "Doe");
        persona.put("apellidoPaterno", "Doe");
        // persona.put("apellido", "Doe2");
        persona.put("email", "john.doe@gmail.com");
        persona.put("edad", "30");

        // Declaramos otro map, llamado direccion
        Map<String, String> direccion = new HashMap<>();
        direccion.put("pais", "USA");
        direccion.put("estado", "California");
        direccion.put("ciudad", "Santa Barbara");
        direccion.put("calle", "One Street");
        direccion.put("numero", "120");

        // Pasamos el map direccion al map person a través del key direccion
        persona.put("direccion", direccion);

        System.out.println("persona = " + persona);


        System.out.println("=== Metodos principales ===");

        System.out.println("=== Metodo get ===");
        // Usando el metodo get, obtenemos el valor del key ingresado, se hace un cast a string ya que el segundo parametro
        // generico se definio como Object
        String nombre = (String) persona.get("nombre");
        String apellido = (String) persona.get("apellido");

        System.out.println(nombre + apellido);

        // Metodo get para obtener el map dentro del map, es necesario hacer le cast, ya que el segundo parametro generico
        // de persona es Object
        Map<String, String> direccionPersona = (Map<String, String>) persona.get("direccion");

        String pais = direccionPersona.get("pais");
        String ciudad = direccionPersona.get("ciudad");
        String barrio = direccionPersona.getOrDefault("barrio", "La playa");
        System.out.println("El pais de " + nombre + " es: " + pais);
        System.out.println("La ciudad de " + nombre + " es: " + ciudad);
        System.out.println("El barrio de " + nombre + " es: " + barrio);

        System.out.println("=== Metodo remove ===");
        // Se tienen dos versiones del metodo remove, una con un solo parametro devuelve el valor que se elimina

        String email = (String) persona.remove("email");
        // Esta version acepta dos parametro, key y value si no se encuentra en el map devuelve false
        boolean b = persona.remove("apellidoPaterno", "Doe");
        System.out.println("eliminado " + b);
        System.out.println("persona = " + persona);
        System.out.println("email = " + email);

        System.out.println("=== Metodo contains ===");
        // Devuelve un booleano si encuentra una coincidencia con el key o value especificado
        boolean b2 = persona.containsKey("apellido");
        System.out.println("b2 = " + b2);

        b2 = persona.containsValue("john.doe@email.co");
        System.out.println("b2 = " + b2);

        System.out.println("========================== values");
        // Devuelve una coleccion de todos los valores del map
        Collection<Object> valores = persona.values();
        for(Object v: valores){
            System.out.println("v = " + v);
        }

        System.out.println("========================= keySet");
        // Devuelve un Set con el valor de todos los keys, devuelve un set ya que las llaves son de valor unico
        Set<String> llaves = persona.keySet();
        for(String k: llaves){
            System.out.println("k = " + k);
        }

        System.out.println("========================== entrySet");
        // El metodo entry set, devuelve un objeto del tipo Map.Entry Set, sobre estos elementos podemos iterar para
        // obtener todos los valores y llaves del map
        for(Map.Entry<String, Object> par: persona.entrySet()){

            Object valor = par.getValue();
            // Revisamos si el valor es un map, para obtener a su vez la llave y el valor
            if(valor instanceof Map){
                Map<String, String> direccionMap = (Map<String, String>) valor;
                for(Map.Entry<String, String> parDir: direccionMap.entrySet()){
                    System.out.println(parDir.getKey() + " => " + parDir.getValue());
                }
            }
            else {
                System.out.println(par.getKey() + " => " + valor);
            }
        }


        System.out.println("========================== Iterando con keySet");

        // Usando el ketSet para iterar sobre todos los elementos
        for(String llave: persona.keySet()){
            Object valor = persona.get(llave);
            if(valor instanceof Map){
                String nom = (String) persona.get("nombre");
                Map<String, String> direccionMap = (Map<String, String>) valor;
                System.out.println("El país de " + nom + ": "
                        + direccionMap.get("pais"));
                System.out.println("El estado de " + nom + ": " + direccionMap.get("estado"));
                System.out.println("La ciudad de " + nom + ": " + direccionMap.get("ciudad"));
            } else {
                System.out.println(llave + " => " + valor);
            }
        }


        System.out.println("========================== java 8 forEach");
        // Al ser una coleccion tenemos acceso al metodo foreach y el uso de expresiones lambda
        persona.forEach((llave, valor) ->{
            System.out.println(llave + " => " + valor);
        });

        System.out.println("========================== Otros");
        System.out.println("total: " + persona.size());
        System.out.println("contiene elementos=" + !persona.isEmpty());
        boolean b3 = persona.replace("nombre", "Jhon", "Andrés");
        System.out.println("b3 = " + b3);
        System.out.println("persona = " + persona);


    }
}
