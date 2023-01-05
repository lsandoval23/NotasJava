package org.lsadoval.hilos.ejemplotimer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class EjemploAgendarTareaTimer {
    public static void main(String[] args) {

        // El metodo schedule de la clase timer, permite ejecutar tareas con temporizaciones.
        // Internamente tenemos que implementar la clase abstracta TimerTask y sobreescribir el metodo run, para ejecutar
        // el hilo que se ejecutará en cada temporizacion. (En este caso solo es un retraso de 5 segundos, existen otras
        // versiones del metodo que permiten realizar tareas periodicas, etc.)
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Tarea Realizada en: " + new Date() + " nombre del Thread "
                + Thread.currentThread().getName());
                System.out.println("Finaliza el tiempo");
                timer.cancel();
            }
        }, 5000);

        System.out.println("Agendamos una tarea para luego de 5 segundos");

    }
}
