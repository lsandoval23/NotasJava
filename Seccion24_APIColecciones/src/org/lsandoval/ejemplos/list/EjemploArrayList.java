package org.lsandoval.ejemplos.list;

import org.lsandoval.ejemplos.modelo.Alumno;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EjemploArrayList {
    public static void main(String[] args) {

        List<Alumno> al = new ArrayList<>();

        // Tamaño de una lista, booleano que indica si la lista esta vacia
        System.out.println(al + ", size = " + al.size());
        System.out.println("Is empty? = " + al.isEmpty());

        // Agregando elementos
        al.add(new Alumno("Pato", 5));
        al.add(new Alumno("Cata", 6));
        al.add(new Alumno("Luci", 4));
        System.out.println("al = " + al);


        // Cuando se pasa un indice al metodo add el nuevo elementos se ubica en esa posicion y los
        // demas se desplazan, si se usa el metodo set el elemento se reemplaza
        al.add(2, new Alumno("Jano", 7));
        System.out.println(al + ", size = " + al.size());
        al.set(3, new Alumno("Andres", 3));
        System.out.println(al + ", size = " + al.size());


        // Eliminando elementos, se toma como criterio de busqueda el nombre y la nota, se puede usar tambien el indice
        // para eliminar el elemento
        al.remove(new Alumno("Jano", 7));
        Alumno alumnoRemove = al.remove(0);   // Se puede obtener el elemento eliminado
        System.out.println(al + ", size = " + al.size());



        // Metodo para averiguar si existe un elemento dentro de la lista, se basa en la
        // sobreescritura de equals and hashcode dentro de la clase Alumno, nuestro caso
        // para que ambas instancias sean iguales, el nombre y la nota deben ser iguales
        boolean b = al.contains(new Alumno("Cata", 7));
        System.out.println("La lista contiene a Cata? = " + b);



        // Convertir la lista a un arreglo
        Object a[] = al.toArray();
        for (int i=0; i<a.length; i++){
            System.out.println("Desde el arreglo = "+ a[i]);
        }


    }
}
