package org.lsadoval.hilos.ejemplosync;

import java.util.concurrent.ThreadLocalRandom;

public class EjemploProductorConsumidorJava8 {

    public static void main(String[] args) {
        Panaderia p = new Panaderia();

        // No creamos una clase, si no que implementamos la interfaz runnable directamente usando expresiones lambda
        new Thread( () -> {
            for(int i = 0; i < 10; i++){
                p.hornear("Pan nº: " + i);
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(500, 2000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread( () -> {
            for(int i = 0 ; i < 10; i++){
                p.consumir();
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(500, 2000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
