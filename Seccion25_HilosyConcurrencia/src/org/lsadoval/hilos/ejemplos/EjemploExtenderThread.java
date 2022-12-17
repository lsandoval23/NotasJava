package org.lsadoval.hilos.ejemplos;


import org.lsadoval.hilos.ejemplos.threads.NombreThread;

public class EjemploExtenderThread {
    public static void main(String[] args) throws InterruptedException {

        // Generamos tres hilos de la clase NombreThread
        Thread hilo = new NombreThread("Jhon Doe");
        hilo.start();

        Thread hilo2 = new NombreThread("Maria");
        hilo2.start();

        NombreThread hilo3 = new NombreThread("Pepe");
        hilo3.start();

        // Observamos el estado del hilo 1, sin un delay se observa el estado RUNNABLE porque el hilo se sigue ejecutando
        // Con el delay adecuado esperando a que el hilo termine, se observa el estado TERMINATED
        Thread.sleep(500);
        System.out.println(hilo.getState());

    }
}
