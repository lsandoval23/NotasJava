package org.rygsol.ejemplo;

import org.rygsol.pooherencia.Alumno;
import org.rygsol.pooherencia.AlumnoInternacional;
import org.rygsol.pooherencia.Profesor;

public class EjemploHerencia {
    public static void main(String[] args) {

        System.out.println("====== Creando la instancia de la clase Alumno =======");
        Alumno alumno = new Alumno();
        alumno.setNombre("Andres");
        alumno.setApellido("Guzman");
        alumno.setInstitucion("Instituto Nacional");
        alumno.setNotaCastellano(5.5);
        alumno.setNotaHistoria(6.3);
        alumno.setNotaMatematica(4.9);



        System.out.println("====== Creando la instancia de la clase Alumno Internacional =======");
        AlumnoInternacional alumnoInt = new AlumnoInternacional();
        alumnoInt.setNombre("Peter");
        alumnoInt.setApellido("Gosling");
        alumnoInt.setPais("Australia");
        alumnoInt.setEdad(15);
        alumnoInt.setInstitucion("Instituto Nacional");
        alumnoInt.setNotaIdiomas(6.8);
        alumnoInt.setNotaCastellano(6.2);
        alumnoInt.setNotaHistoria(5.8);
        alumnoInt.setNotaMatematica(6.5);


        System.out.println("====== Creando la instancia de la clase Profesor =======");
        Profesor profesor = new Profesor();
        profesor.setNombre("Luci");
        profesor.setApellido("Perez");
        profesor.setAsignatura("Matematicas");


        System.out.println("======  =======");

        System.out.println(alumno.getNombre() + " " + alumno.getApellido());
        System.out.println("Profesor: " + profesor.getNombre() + " " + profesor.getApellido());


        // Mostramos toda la jerarquia de la clase AlumnoInt
        Class clase = alumnoInt.getClass();
        while(clase.getSuperclass() != null){
            String hija = clase.getName();
            String padre = clase.getSuperclass().getName();
            System.out.println(hija + " es una clase hija de la clase padre: " + padre);
            clase = clase.getSuperclass();
        }

    }
}
