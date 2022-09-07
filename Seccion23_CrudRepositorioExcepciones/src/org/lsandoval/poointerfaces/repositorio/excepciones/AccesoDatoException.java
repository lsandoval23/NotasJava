package org.lsandoval.poointerfaces.repositorio.excepciones;

// Excepcion chequeada principal las demas excepciones serán hijas de esta clase.
public class AccesoDatoException extends Exception{
    public AccesoDatoException(String message) {
        super(message);
    }
}
