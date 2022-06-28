package org.lsandoval.clasesabstractas.form.elementos;

abstract public class ElementoForm {

    protected String valor;
    protected String nombre;

    public ElementoForm() {
    }

    public ElementoForm(String nombre) {
        this();
        this.nombre = nombre;
    }


    // Solo se declara un set, dentro de dibujarHtml se mostraran el valor y el nombre por lo que no es necesario el getter
    // de estos atributos

    public void setValor(String valor) {
        this.valor = valor;
    }

    // Metodos abstractos requieren clases abstractas
    abstract public String dibujarHtml();


}
