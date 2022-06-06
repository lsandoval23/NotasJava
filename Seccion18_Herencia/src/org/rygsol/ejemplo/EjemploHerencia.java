package org.rygsol.ejemplo;

import org.rygsol.pooherencia.Alumno;
import org.rygsol.pooherencia.Profesor;

public class EjemploHerencia {
    public static void main(String[] args) {

        Alumno alumno = new Alumno();
        alumno.setNombre("Andres");
        alumno.setApellido("Guzman");
        
        Profesor profesor = new Profesor();
        profesor.setNombre("Luci");
        profesor.setApellido("Perez");
        profesor.setAsignatura("Matematicas");

        System.out.println(alumno.getNombre() + " " + alumno.getApellido());
        System.out.println("Profesor: " + profesor.getNombre() + " " + profesor.getApellido());



    }
}
