package org.lsandoval.clasesabstractas.form.elementos.select;

public class Opcion {
    private String valor;
    private String nombre;
    private Boolean selected = false;

    public Opcion() {
    }

    public Opcion(String valor, String nombre) {
        this.valor = valor;
        this.nombre = nombre;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    public Opcion setSelected(){
        this.selected = true;
        return this;
    }

    public boolean isSelected() {
        return selected;
    }
}
