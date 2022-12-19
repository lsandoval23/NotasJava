package org.lsadoval.hilos.ejemplos;

public class EjemploInterfaceRunnableJava8 {
    // Como la interfaz Runnable es funcional se puede hacer su implementacion usando expresiones lambda
    public static void main(String[] args) {

        // El metodo estatico currentThread devuelve una instancia del hilo actual, en este caso el hilo main
        Thread main = Thread.currentThread();

        // Implementamos el metodo run() que no acepta parametros
        Runnable viaje = () -> {

            for(int i=0; i < 10; i++){
                // En este caso el metodo currentThread hara referencia al hilo sobre el que se instacie
                System.out.println(i + " - " + Thread.currentThread().getName());
                try {
                    Thread.sleep( (long)(Math.random() * 1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Finalmente me voy de viaje a: " + Thread.currentThread().getName());
        };

        // La clase thread acepta un constructor con parametros runnable y name del Thread
        Thread v1 = new Thread(viaje, "Isla de Pascua");
        v1.start();
        Thread v2 = new Thread(viaje, "Robinson Crusoe");
        v2.start();

        System.out.println("Continuando con la ejecución del método main: " + main.getName());


    }
}
