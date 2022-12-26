package org.lsadoval.hilos.ejemplos;

import org.lsadoval.hilos.ejemplos.runnable.ImprimirFrases;

public class EjemploSincronizacionThread {
    public static void main(String[] args) throws InterruptedException {

        // Inicializamos hilos que intentan acceder a la misma funcion estatica
        // Debido al delay dentro de la funcion imprimirFrases, tenemos diversos hilos que intentan acceder
        // a la misma funcion simultaneamente antes de que otro hilo termine de usarlo.

        new Thread(new ImprimirFrases("Hola ", "que tal!")).start();
        new Thread(new ImprimirFrases("¿Quién eres ", "tú?")).start();
        Thread.sleep(100);
        Thread h3 = new Thread(new ImprimirFrases("Muchas ", "gracias amigo!"));
        h3.start();
        Thread.sleep(100);
        System.out.println(h3.getState());

    }

    // Si usamos el modificador synchronized, este indicara que se termine de usar el recurso antes
    // de que otro hilo lo use, el hilo que intente acceder al recurso tendrá el estado BLOCKED ya que
    // necesita que el hilo actual que lo use, termine de ejecutarse
    public synchronized static void imprimirFrases(String frase1, String frase2){
        System.out.println(frase1);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(frase2);

    }



}
