package org.rygsol.pooherencia;

public class AlumnoInternacional extends  Alumno {
    private String Pais;
    private double notaIdiomas;

    public String getPais() {
        return Pais;
    }

    public void setPais(String pais) {
        Pais = pais;
    }

    public double getNotaIdiomas() {
        return notaIdiomas;
    }

    public void setNotaIdiomas(double notaIdiomas) {
        this.notaIdiomas = notaIdiomas;
    }
}
