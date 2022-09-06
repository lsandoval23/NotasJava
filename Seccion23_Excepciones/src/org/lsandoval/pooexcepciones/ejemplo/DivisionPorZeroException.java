package org.lsandoval.pooexcepciones.ejemplo;

// Creamos nuestras propias excepciones Checked ya que heredan de la clase Exception, esto nos obligara
// a tratar las excepciones en tiempo de compilacion (Necesariamente tienen que estar dentro de un bloque try)

public class DivisionPorZeroException extends Exception {
    public DivisionPorZeroException(String message) {
        super(message);
    }
}
