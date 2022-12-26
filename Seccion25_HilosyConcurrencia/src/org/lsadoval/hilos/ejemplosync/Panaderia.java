package org.lsadoval.hilos.ejemplosync;

public class Panaderia {

    private String pan;
    private boolean disponible; // default false

    // Se tienen dos metodos dentro de la clase Panaderia que seran recursos compartidos para los hilos
    // Consumidor y Panadero.

    // El objetivo es que se pueda llamar al metodo consumir solo cuando previamente se halla llamado al metodo hornear

    public synchronized void hornear(String masa){
        while (disponible){
            try {
                // el metodo wait le dice al hilo que quiere acceder al metodo hornear, que espere hasta que sea
                // notificado con el motodo notify() que ya puede continuar con su ejecucion (Esto sucede una vez el
                // cliente termina de consumir un pan)
                wait();
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
        }

        this.pan = masa;
        System.out.println("Panadero hornea: " + this.pan);
        this.disponible = true;
        notify(); // Notificamos a todos los hilos que intenten acceder a este metodo que ya se encuentra disponible luego del wait.
    }

    // El hilo Consumidor no podrá usar el recurso consumir , hasta que la variable disponible se encuentre en true (Esto sucede cuando
    // un pan se termina de hornear en el metodo hornear())

    public synchronized String consumir(){

        while(!disponible){
            try {
                // Si existe nuevamente un llamada al metodo consumir en el hilo Consumidor, se espera a que el hilo se despierte usando notify
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Cliente consume: " + this.pan);
        this.disponible = false;
        notify();
        return pan;
    }


}
