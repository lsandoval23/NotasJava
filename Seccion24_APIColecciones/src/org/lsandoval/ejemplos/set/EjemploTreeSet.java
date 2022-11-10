package org.lsandoval.ejemplos.set;

import com.sun.source.doctree.SeeTree;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class EjemploTreeSet {
    public static void main(String[] args) {

        // Los treeset si poseen un orden en sus elementos, pero tiene costo de computo en su implementacion
        // el ordenamiento lo hace automaticamente, mantienen sus propiedades de no permitir elementos duplicados.


        // Se puede sobreescribir el metodo compare, en este caso usando una expresion lambda, para hacer un ordenamiento
        // inversa.
        Set<String> ts = new TreeSet<>((a, b) -> b.compareTo(a));
        
        ts.add("uno");
        ts.add("dos");
        ts.add("tres");
        ts.add("cuatro");
        ts.add("cinco");
        ts.add("tres");


        System.out.println("ts = " + ts);


        // El ordenamiento se hace en base a la implementación de la interfaz Comparable, en el metodo compare del generico
        // que se pasa como parametro (String en este caso, y el orden se hace de forma alfabetica)
        Set<Integer> numeros = new TreeSet<>(Comparator.reverseOrder());
        numeros.add(1);
        numeros.add(5);
        numeros.add(4);
        numeros.add(2);
        numeros.add(3);
        numeros.add(10);

        System.out.println("numeros = " + numeros);
    }
}
