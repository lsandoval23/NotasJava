package org.lsadoval.hilos.ejemplos.runnable;


// El segundo metodo para generar un hilo es implementando la interfaz runnable, esta es una interfaz funcional por lo que
// se puede implementar usando expresiones lambda. Permite mas desacoplamiento ya que la clase no hereda de la clase Thread
// dejandola libre para que herede de otra si lo necesita

public class ViajeTarea implements Runnable{

    // Generamos atributos y constructor para darle nombre al hilo
    private String nombre;

    public ViajeTarea(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void run() {

        for(int i=0; i < 10; i++){
            System.out.println(i + " - " + nombre);
            try {
                Thread.sleep( (long)(Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Finalmente me voy de viaje a: " + nombre);

    }
}
