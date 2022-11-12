package org.lsandoval.ejemplos.set;

import org.lsandoval.ejemplos.modelo.Alumno;

import java.util.*;

public class EjemploHashSetUnicidad {
    public static void main(String[] args) {

        // Por defecto si no implementamos los metodos equals and hashcode en la clase Alumno
        // Comparara las direcciones de memoria para ver si los elementos son iguales

        List<Alumno> sa = new ArrayList<>();

        sa.add(new Alumno("Pato", 5));
        sa.add(new Alumno("Cata", 6));
        sa.add(new Alumno("Luci", 4));
        sa.add(new Alumno("Jano", 7));
        sa.add(new Alumno("Andres", 3));

        // Cada nueva instancia es diferente asi posea ambos atributos iguales, una vez se implementen los metodos
        // equals and hashcode ya se reconoceran como instancias iguales
        sa.add(new Alumno("Zeus", 2));
        sa.add(new Alumno("Zeus", 2));

        System.out.println("sa = " + sa);


        /** Iterando sobre colecciones **/

        // El metodo get solo aplica para las listas, los set al no tener un orden no tienen un indice
        // Con sets no se pueden hacer iteraciones con un for clasico
        System.out.println("Utilizando un for clasico");
        for (int i=0; i<sa.size(); i++){
            Alumno a = sa.get(i);
            System.out.println(a.getNombre());
        }


        // Estos metodos aplican tanto para list (ArrayList) como para set (HashSet, TreeSet)
        System.out.println("Iterando usando foreach");
        for (Alumno a: sa){
            System.out.println(a.getNombre());
        }

        System.out.println("Iterando usando while y iterator");
        Iterator<Alumno> it = sa.iterator();
        while (it.hasNext()){
            Alumno a = it.next();
            System.out.println(a.getNombre());
        }

        System.out.println("Iterando usando streams");
        sa.forEach(System.out::println);


    }
}
