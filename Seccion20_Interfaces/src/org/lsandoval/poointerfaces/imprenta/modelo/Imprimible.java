package org.lsandoval.poointerfaces.imprenta.modelo;

public interface Imprimible {

    // Las interfaces pueden tener metodos implementados por defecto y constantes internas que pueden ser usadas
    // dentro de la interfase. Los metodos implementados por defecto no necesitan ser sobreescrito de manera obligatoria.

    // Por defecto cualquier atributo declarado dentro de una interfaz en final y static
    final static String SALUDO = "Hola, este es la impresion por defecto";

    public String imprimir();
    default String imprimirSaludo(){
        return SALUDO;
    }
}
