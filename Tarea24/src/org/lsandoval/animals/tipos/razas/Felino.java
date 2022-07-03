package org.lsandoval.animals.tipos.razas;

import org.lsandoval.animals.tipos.Mamifero;

abstract public class Felino extends Mamifero {

    private Float tamanioGarras;
    private Integer velocidad;

    public Felino(String habitat, Float altura, Float largo, Float peso, String nombreCientifico, Float tamanioGarras, Integer velocidad) {
        super(habitat, altura, largo, peso, nombreCientifico);
        this.tamanioGarras = tamanioGarras;
        this.velocidad = velocidad;
    }

    public Float getTamanioGarras() {
        return tamanioGarras;
    }

    public Integer getVelocidad() {
        return velocidad;
    }
}
