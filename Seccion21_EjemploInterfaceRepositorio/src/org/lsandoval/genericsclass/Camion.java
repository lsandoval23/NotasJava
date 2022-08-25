package org.lsandoval.genericsclass;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Implementar la interfaz iterable permite aplicar un for loop sobre cada elemento de la clase. En la clase
// el argumento generico va después del nombre de la clase.

public class Camion<T> implements Iterable<T> {

    // La clase camion contiene como atributo una lista de la clase generica T. Si no se usara el generico

    private List<T> objetos;
    private int max;

    public Camion(int max) {
        this.max = max;
        this.objetos = new ArrayList<>();
    }

    // Si no se usara un generico, la implementación del metodo add seria:
    // public void add (Object objeto), se tiene que espificar que tipo de objetos tiene la lista,
    // para hacerlo de la forma mas general se usa la clase Object que es la clase padre.

    public void add(T objeto){
        if(this.objetos.size() <= max) {
            this.objetos.add(objeto);
        } else {
            throw new RuntimeException("no hay más espacio.");
        }
    }

    // Para el iterator de la clase usamos el iterator del atributo List<T>
    @Override
    public Iterator<T> iterator() {
        return this.objetos.iterator();
    }
}
