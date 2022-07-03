package org.lsandoval.clasesabstractas.form.elementos;
import org.lsandoval.clasesabstractas.form.validador.Validador;

import java.util.ArrayList;
import java.util.List;

abstract public class ElementoForm {

    protected String valor;
    protected String nombre;

    private List<Validador> validadores;
    private  List<String> errores;


    public ElementoForm() {
        this.validadores = new ArrayList<>();
        this.errores = new ArrayList<>();
    }

    public ElementoForm(String nombre) {
        this();
        this.nombre = nombre;
    }



    public ElementoForm addValidador(Validador validador){
        this.validadores.add(validador);
        return this;
    }

    public List<String> getErrores() {
        return errores;
    }

    // Solo se declara un set, dentro de dibujarHtml se mostraran el valor y el nombre por lo que no es necesario el getter
    // de estos atributos

    public void setValor(String valor) {
        this.valor = valor;
    }

    /*
    public String getNombre() {
        return nombre;
    }
    */

    // Metodos abstractos requieren clases abstractas
    abstract public String dibujarHtml();

    public boolean esValido(){
        for (Validador v: validadores){
            if (!v.esValido(this.valor)){
                this.errores.add(String.format(v.getMensaje(), this.nombre));
            }
        }

        // isEmpty es un metodo de List que devuelve un booleano dependiendo del tamanio de la lista
        return this.errores.isEmpty();

    }


}
