package org.lsandoval.ejemplos.set;

import org.lsandoval.ejemplos.modelo.Alumno;

import java.util.Set;
import java.util.TreeSet;

public class EjemploTreeSetComparable {
    public static void main(String[] args) {


        // Para que Alumno pueda ser parte de un TreeSet debe implementar la interfaz Comparable
        // Asi se sabe bajo que criterio se ordena, tambien es bajo este criterio que se toma si un objeto es duplicado

        Set<Alumno> sa = new TreeSet<>();
        sa.add(new Alumno("Pato", 5));
        sa.add(new Alumno("Cata", 6));
        sa.add(new Alumno("Luci", 4));
        sa.add(new Alumno("Jano", 7));
        sa.add(new Alumno("Andres", 3));
        sa.add(new Alumno("Zeus", 3));
        sa.add(new Alumno("Zeus", 2));

        System.out.println("sa = " + sa);
        
    }
}
