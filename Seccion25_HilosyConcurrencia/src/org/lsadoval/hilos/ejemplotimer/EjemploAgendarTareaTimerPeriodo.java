package org.lsadoval.hilos.ejemplotimer;

import java.awt.*;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class EjemploAgendarTareaTimerPeriodo {
    public static void main(String[] args) {

        // La clase Toolkit permite generar el beep, que sirve para emitir sonidos del Sistema Operativo
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        // AtomicInteger permite que se pueda usar esta variable dentro de la clase anonima que extiene a TimerTask
        AtomicInteger contadorAtomic = new AtomicInteger(3);
        Timer timer = new Timer();
        timer.schedule(new TimerTask(){
            @Override
            public void run() {
                // Obtenemos y luego decrementamos el valor de la variable contadorAtomic
                int i = contadorAtomic.getAndDecrement();
                if(i > 0) {
                    toolkit.beep();
                    System.out.println("Tarea " +i+ " periódica en: "
                            + new Date() + " nombre del Thread: "
                            + Thread.currentThread().getName());
                } else {
                    // Una vez finaliza el contador, se cancela el timer para que se deje de iterar cada 10 segundos.
                    System.out.println("Finaliza el tiempo");
                    timer.cancel();
                }
            }
        }, 0, 10000);

        System.out.println("Agendamos una tarea inmediata que se repite cada 10 seg ...");
    }
}