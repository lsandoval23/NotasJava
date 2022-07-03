package org.lsandoval.animals.tipos.razas.especies;

import org.lsandoval.animals.tipos.razas.Canino;

public class Leon extends Canino {

    private Integer numeroManada;
    private Float potenciaRuido;


    public Leon(String habitat, Float altura, Float largo, Float peso, String nombreCientifico, String color, Float tamanioColmillos) {
        super(habitat, altura, largo, peso, nombreCientifico, color, tamanioColmillos);
    }

    @Override
    public String comer() {
        return null;
    }

    @Override
    public String dormir() {
        return null;
    }

    @Override
    public String correr() {
        return null;
    }

    @Override
    public String comunicarse() {
        return null;
    }
}
