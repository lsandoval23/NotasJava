package org.lsandoval.animals.tipos.razas;

import org.lsandoval.animals.tipos.Mamifero;

abstract public class Canino extends Mamifero {

    private String color;
    private Float tamanioColmillos;

    public Canino(String habitat, Float altura, Float largo, Float peso, String nombreCientifico, String color, Float tamanioColmillos) {
        super(habitat, altura, largo, peso, nombreCientifico);
        this.color = color;
        this.tamanioColmillos = tamanioColmillos;
    }

    public String getColor() {
        return color;
    }

    public Float getTamanioColmillos() {
        return tamanioColmillos;
    }
}
