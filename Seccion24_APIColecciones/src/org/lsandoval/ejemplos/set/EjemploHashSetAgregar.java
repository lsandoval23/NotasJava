package org.lsandoval.ejemplos.set;

import java.util.*;

public class EjemploHashSetAgregar {
    public static void main(String[] args) {

        // La interfaz general es Set, puede usarse la clase especifica que implementa la interfaz
        // HashSet<String>
        Set<String> hs = new HashSet<>();
        hs.add("uno");
        hs.add("dos");
        hs.add("tres");
        hs.add("cuatro");
        hs.add("cinco");

        System.out.println(hs);

        boolean b = hs.add("tres");
        System.out.println("Permite Elementos duplicados: " + b);
        System.out.println(hs);

        // Se pueden generar listas a partir de otros tipos de colecciones, las listas si
        // se pueden ordenar, a diferencia de los hashset que no tienen orden en sus elementos
        System.out.println("======== Listas a partir de hashset =======");
        List<String> list = new ArrayList<>(hs);
        Collections.sort(list);
        System.out.println(list);

    }
}
