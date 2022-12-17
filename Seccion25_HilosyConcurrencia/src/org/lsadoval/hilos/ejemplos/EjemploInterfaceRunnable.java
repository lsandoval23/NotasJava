package org.lsadoval.hilos.ejemplos;

import org.lsadoval.hilos.ejemplos.runnable.ViajeTarea;

public class EjemploInterfaceRunnable {

    public static void main(String[] args) {

        // El constructor de la clase thread permite como argumento una interfaz runnable
        new Thread(new ViajeTarea("Isla de Pascua")).start();
        new Thread(new ViajeTarea("Robinson Crusoe")).start();
        new Thread(new ViajeTarea("Juan Fernandez")).start();
        new Thread(new ViajeTarea("Isla de Chiloe")).start();
    }
}
