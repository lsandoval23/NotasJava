package org.lsandoval.clasesabstractas.form.validador;

public class EmailValidador extends Validador{

    protected String mensaje = "el formato de email es inválido";
    private final static String EMAIL_REGEX = "^(.+)@(.+)$";

    @Override
    void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String getMensaje() {
        return mensaje;
    }

    @Override
    public boolean esValido(String valor) {
        //matches para verificar que valor coincida con la expresion regular
        return valor.matches(EMAIL_REGEX);
    }
}
