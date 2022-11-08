package org.lsandoval.ejemplos.set;

import java.util.HashSet;
import java.util.Set;

public class EjemploHashSetBuscarDuplicados2 {
    public static void main(String[] args) {

        String[] peces = {"Corvina", "Corvina","Lenguado", "Pejerrey", "Robalo", "Atun", "Lenguado"};

        // Usamos otro hashset para guardar los elementos duplicados
        Set<String> unicos = new HashSet<>();
        Set<String> duplicados = new HashSet<>();

        for(String pez: peces){
            if (!unicos.add(pez)){
                System.out.println("Elemento duplicado: " + pez);
                duplicados.add(pez);
            }
        }

        // Eliminamos los elementos duplicados del hashset original
        unicos.removeAll(duplicados);
        System.out.println("unicos: " + unicos);
        System.out.println("duplicados: " + duplicados);

    }
}
