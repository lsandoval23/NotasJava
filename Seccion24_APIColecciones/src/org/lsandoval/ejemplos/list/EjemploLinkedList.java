package org.lsandoval.ejemplos.list;

import org.lsandoval.ejemplos.modelo.Alumno;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class EjemploLinkedList {
    public static void main(String[] args) {

        // Los LinkedList están optimizados para funcionar como pilas y colas, es decir tiene optimizaciones
        // para trabajar con el primer y ultimo elementos de la lista

        LinkedList<Alumno> enlazada =  new LinkedList<>();
        System.out.println(enlazada + ", size = " + enlazada.size());
        System.out.println("está vacía = " + enlazada.isEmpty());

        // Añadiendo elementos

        enlazada.add(new Alumno("Pato", 5));
        enlazada.add(new Alumno("Cata", 6));
        enlazada.add(new Alumno("Luci", 4));
        enlazada.add(new Alumno("Jano", 7));
        enlazada.add(new Alumno("Andres", 3));

        System.out.println(enlazada + ", size = " + enlazada.size());

        // No se puede usar la interfaz generica en la declaracion, el metodo addFirst y addLast es solo para
        // las listas enlazada
        enlazada.addFirst(new Alumno("Zeus", 5));
        enlazada.addLast(new Alumno("Atenea", 6));
        System.out.println(enlazada + ", size = " + enlazada.size());

        // Obteniendo elementos

        System.out.println("Primero = " + enlazada.getFirst());
        // Existe el metodo alternativo peek, a diferencia de getFirst no devuelve una excepcion si la lista esta vacia
        // solo devuelve un null, lo mismo para peekLast
        System.out.println("Primero = " + enlazada.peekFirst());
        System.out.println("Último = " + enlazada.getLast());
        System.out.println("Último = " + enlazada.peekLast());
        System.out.println("Indice 2 = " + enlazada.get(2));


        // Eliminando elementos

        enlazada.removeFirst();
        // enlazada.pop(); similar a removeFirst
        // enlazada.pollLast(); existe el metodo alternativo a remove, que no genera una excepcion. Solo devuelve un valor null
        enlazada.removeLast();
        System.out.println(enlazada + ", size = " + enlazada.size());
        // Se puede eliminar en base a los atributos y no al indice
        enlazada.remove(new Alumno("Luci", 4));
        // tambien se puede usar indice:  enlazada.remove(1);
        System.out.println(enlazada + ", size = " + enlazada.size());

        // Reemplazando elementos y obteniendo indices
        enlazada.set(1, new Alumno("Lalo", 7));
        Alumno a = new Alumno("Lalo", 7);
        System.out.println(enlazada + ", size = " + enlazada.size());
        System.out.println("Indice de Lalo = " + enlazada.indexOf(a));

        // Iterando sobre los elementos usando listIterator(), a diferencia del iterator
        // este permite iterar de forma inversa sobre los elementos

        ListIterator<Alumno> li = enlazada.listIterator();

        while(li.hasNext()){
            Alumno alumno = li.next();
            System.out.println(alumno);
        }
        System.out.println("=================== Previous");
        while(li.hasPrevious()){
            Alumno alumno = li.previous();
            System.out.println(alumno);
        }








    }
}
