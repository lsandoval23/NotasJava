package org.lsandoval.clasesabstractas.form.validador;

abstract public class Validador {

    // Mensaje que guarda el error del validador
    protected  String mensaje;

    abstract void setMensaje(String mensaje);
    abstract public String getMensaje();
    abstract public boolean esValido(String valor);
}
