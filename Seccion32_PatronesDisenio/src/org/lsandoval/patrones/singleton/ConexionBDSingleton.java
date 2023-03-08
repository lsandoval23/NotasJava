package org.lsandoval.patrones.singleton;

public class ConexionBDSingleton {

    // Se tiene un atributo estatico de la misma clase, de esta forma se comparte este atributo para todas las instancias
    private static ConexionBDSingleton instancia;

    // Para restringir la creacion de multiples instancias, hacemos que el constructor sea privado
    // Solo puede ser llamada dentro de la propia clase
    private ConexionBDSingleton(){
        System.out.println("Conectandose algun motor de base de datos");
    }

    // Definimos un metodo estatico que puede ser llamado de cualquier otra parte, y gestiona que la instancia que se
    // tiene no sea nueva.
    public static ConexionBDSingleton getInstancia(){
        if (instancia == null){
            instancia = new ConexionBDSingleton();
        }

        return instancia;
    }


}
