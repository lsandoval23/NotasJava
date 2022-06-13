package org.rygsol.pooherencia;

public class AlumnoInternacional extends  Alumno {
    private String Pais;
    private double notaIdiomas;

    public AlumnoInternacional() {
        System.out.println("Alumno Internacional: inicializando constructor ...");
    }

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
