package org.lsandoval.ejemplos.list;

import org.lsandoval.ejemplos.modelo.Alumno;

import java.util.*;

public class EjemploListComparableComparator {
    public static void main(String[] args) {

        List<Alumno> sa = new ArrayList<>();

        sa.add(new Alumno("Pato", 5));
        sa.add(new Alumno("Cata", 6));
        sa.add(new Alumno("Luci", 4));
        sa.add(new Alumno("Jano", 7));
        sa.add(new Alumno("Andres", 3));
        sa.add(new Alumno("Zeus2", 2));
        sa.add(new Alumno("Zeus", 1));
        sa.add(new Alumno("Lucas", 2));
        sa.add(new Alumno("Lucas", 3));

        /** Implementando orden en las listas, a diferencia de un TreeSet esto no se hace de forma automatica **/
        System.out.println("==== Lista original ====");
        System.out.println(sa);


        System.out.println("==== Usando la clase helper Collections, el metodo sort ====");
        // Si no se especifica un metodo de ordenamiento toma el criterio del metodo compareTo de la clase Alumno,
        // en este caso en base a la nota
        Collections.sort(sa);
        System.out.println(sa);

        // Se puede especificar un metodo usando una expresion lambda, en este caso ordenamos la lista en base al nombre
        Collections.sort(sa, (a,b) -> {
            return a.getNombre().compareTo(b.getNombre());
        });
        System.out.println(sa);

        System.out.println("==== Usando el metodo sort de cada instancia de la lista ====");
        // El metodo solicita una expresion lambda para implementar el metodo compare
        // Se ordena de forma descendente en base a la nota
        sa.sort( (a,b) -> b.getNota().compareTo(a.getNota()) );
        System.out.println(sa);


        System.out.println("==== Usando el metodo comparing ====");
        // Se ordena en base a la nota
        sa.sort(Comparator.comparing((Alumno a) -> a.getNota()).reversed());
        //sa.sort(comparing(Alumno::getNombre).reversed());
        System.out.println(sa);









    }
}
