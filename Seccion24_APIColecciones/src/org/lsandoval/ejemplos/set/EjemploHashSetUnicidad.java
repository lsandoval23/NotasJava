package org.lsandoval.ejemplos.set;

import org.lsandoval.ejemplos.modelo.Alumno;

import java.util.HashSet;
import java.util.Set;

public class EjemploHashSetUnicidad {
    public static void main(String[] args) {

        // Por defecto si no implementamos los metodos equals and hashcode en la clase Alumno
        // Comparara las direcciones de memoria para ver si los elementos son iguales

        Set<Alumno> sa = new HashSet<>();

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

    }
}
