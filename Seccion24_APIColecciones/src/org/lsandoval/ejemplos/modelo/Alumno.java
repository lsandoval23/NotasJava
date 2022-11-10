package org.lsandoval.ejemplos.modelo;

import java.util.Objects;

public class Alumno implements Comparable<Alumno>{

    private String nombre;
    private Integer nota;


    public Alumno() {
    }

    public Alumno(String nombre, Integer nota) {
        this.nombre = nombre;
        this.nota = nota;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }


    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", nota=" + nota +
                '}';
    }

    // Se implementa el compare to para que los treeset tengan un criterio de ordenamiento
    @Override
    public int compareTo(Alumno a) {
        /*
        if (this.nombre == null){
            return 0;
        }
        return a.nombre.compareTo(this.nombre);
        */


        // Se puede implementar el criterio de comparacion en base a la nota
        if(this.nota == null){
            return 0;
        }
        return this.nota.compareTo(a.nota);

    }

    // Sobreescribimos los metodos equals y hashcode para que el hashset use como criterio de comparación los atributos
    // nombre y nota
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return Objects.equals(nombre, alumno.nombre) && Objects.equals(nota, alumno.nota);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, nota);
    }
}
