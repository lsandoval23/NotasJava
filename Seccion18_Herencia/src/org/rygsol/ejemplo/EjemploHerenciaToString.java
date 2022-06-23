package org.rygsol.ejemplo;

import org.rygsol.pooherencia.Alumno;
import org.rygsol.pooherencia.AlumnoInternacional;
import org.rygsol.pooherencia.Persona;
import org.rygsol.pooherencia.Profesor;

public class EjemploHerenciaToString {
    public static void main(String[] args) {

        System.out.println("====== Creando la instancia de la clase Alumno =======");
        Alumno alumno = new Alumno("Andres", "Guzman", 41, "Instituto Nacional");
        alumno.setNotaCastellano(5.5);
        alumno.setNotaHistoria(6.3);
        alumno.setNotaMatematica(4.9);
        alumno.setEmail("andree@gmail.com");


        System.out.println("====== Creando la instancia de la clase Alumno Internacional =======");
        AlumnoInternacional alumnoInt = new AlumnoInternacional("Peter", "Gosling", "Australia");
        alumnoInt.setEdad(15);
        alumnoInt.setInstitucion("Instituto Nacional");
        alumnoInt.setNotaIdiomas(6.8);
        alumnoInt.setNotaCastellano(6.2);
        alumnoInt.setNotaHistoria(5.8);
        alumnoInt.setNotaMatematica(6.5);
        alumnoInt.setEmail("peter@correo.com");


        System.out.println("====== Creando la instancia de la clase Profesor =======");
        Profesor profesor = new Profesor("Luci","Perez", "Matematicas" );
        profesor.setEdad(37);

        System.out.println(" ======= - ========");

        imprimir(alumno);
        imprimir(alumnoInt);
        imprimir(profesor);



    }


    public static void imprimir(Persona persona){
        System.out.println(persona);
    }
}
