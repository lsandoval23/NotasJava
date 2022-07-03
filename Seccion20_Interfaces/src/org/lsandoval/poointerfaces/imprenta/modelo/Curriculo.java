package org.lsandoval.poointerfaces.imprenta.modelo;

import java.util.ArrayList;
import java.util.List;

public class Curriculo extends Hoja{

    private String persona;
    private String carrera;
    private List<String> experiencias;

    public Curriculo(String contenido, String persona, String carrera) {
        super(contenido);
        this.persona = persona;
        this.carrera = carrera;
        this.experiencias = new ArrayList<>();
    }

    public Curriculo addExperiencia(String exp){
        this.experiencias.add(exp);
        return this;
    }


    @Override
    public String imprimir() {
        StringBuilder sb = new StringBuilder("Nombre: ");
        sb.append(persona).append("\n")
                .append("Resumen: ").append(this.contenido)
                .append("\n").append("Profesion: ")
                .append(this.carrera).append("\n")
                .append("Experiencias: \n");

        for(String exp: this.experiencias){
            sb.append("\t- ").append(exp).append("\n");
        }

        return sb.toString();
    }
}
