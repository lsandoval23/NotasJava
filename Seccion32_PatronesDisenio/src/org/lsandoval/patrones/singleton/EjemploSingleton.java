package org.lsandoval.patrones.singleton;

public class EjemploSingleton {
    public static void main(String[] args) {

        ConexionBDSingleton con = null;

        // Generamos 10 instancias e imprimimos sus direcciones de memoria, gracias al patron singleton
        // todas deben apuntar a la misma direccion
        for (int i=0; i<10; i++){
            con = ConexionBDSingleton.getInstancia();
            System.out.println("con = " + con);
        }


    }
}
