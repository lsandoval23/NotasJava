package org.lsadoval.hilos.ejemplos.threads;

// Primer metodo para generar un hilo, heredando de la clase Thread
// Esta forma impide que la clase NombreThread herede de otra y la restringe, por eso se recomienda más hacer uso
// de la interfaz Runnable
public class NombreThread extends Thread{

    // Sobrecargando constructor, para darle un nombre al hilo
    public NombreThread(String name) {
        super(name);
    }

    // Sobrescribiendo el metodo run, en este bloque estara el proceso que ejecuta el hilo.
    @Override
    public void run() {
        System.out.println("se inicia el método run del hilo " + getName());

        for(int i = 0; i < 10; i++){
            try {
                // Manda un delay al hilo actual (hilo NombreThread), el metodo sleep es un metodo estatico de la clase Thread.
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.getName());
        }
        System.out.println("finaliza el hilo " + getName());
    }
}
