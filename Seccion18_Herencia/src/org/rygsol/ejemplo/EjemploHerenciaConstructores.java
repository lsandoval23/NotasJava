package org.rygsol.ejemplo;

import org.rygsol.pooherencia.Alumno;
import org.rygsol.pooherencia.AlumnoInternacional;
import org.rygsol.pooherencia.Persona;
import org.rygsol.pooherencia.Profesor;

public class EjemploHerenciaConstructores {
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
        System.out.println("Imprimiendo datos en comun del tipo Persona");
        System.out.println("nombre: " + persona.getNombre()
                + ", apellido:  " + persona.getApellido()
                + ", edad: " + persona.getEdad()
                + ", email: " + persona.getEmail());

        // Control de tipo
        if(persona instanceof Alumno){
            System.out.println("Imprimiendo los datos del tipo Alumno");
            System.out.println("Institucion: " + ((Alumno) persona).getInstitucion());
            System.out.println("Nota matematica: " + ((Alumno) persona).getNotaMatematica());
            System.out.println("Nota Historia: " + ((Alumno) persona).getNotaHistoria());
            System.out.println("Nota Castellanoo: " + ((Alumno) persona).getNotaCastellano());

            if(persona instanceof AlumnoInternacional){
                System.out.println("Imprimiendo los datos del tipo Alumno Internacional");
                System.out.println("Nota Idiomas: " + ((AlumnoInternacional) persona).getNotaIdiomas());
                System.out.println("Pais: " + ((AlumnoInternacional) persona).getPais());
            }

            System.out.println(" ======= sobre escritura promedio =======");
            // A pesar de que se usa la clase alumno, si un objeto de la clase alumno internacional llama
            // al metodo calcularPromedio llamara a su propio metodo
            System.out.println("Promedio " + ((Alumno) persona).calcularPromedio());
            System.out.println(" ======= sobre escritura promedio =======");

        }

        if(persona instanceof Profesor){
            System.out.println("Imprimiendo los datos del tipo Profesor");
            System.out.println("Asignatura: " + ((Profesor) persona).getAsignatura());

        }

        System.out.println("===== sobre escritura saludar =====");

        System.out.println(persona.saludar());

        System.out.println("===== - =====");
    }
}
