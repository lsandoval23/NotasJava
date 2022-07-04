package org.lsandoval.poointerfaces.imprenta;

import org.lsandoval.poointerfaces.imprenta.modelo.*;

public class EjemploImprenta {
    public static void main(String[] args) {

        Curriculo cv = new Curriculo("Resumen laboral....", "John Doe", "Ingeniero de sistemas");
        cv.addExperiencia("Java");
        cv.addExperiencia("Oracle DBA").addExperiencia("Spring Framework")
                .addExperiencia("Desarrollador fullstack").addExperiencia("Angular");

        Libro libro = new Libro("Erich Gamma", "Patrones de diseño: Elem. Reusable POO",
                Genero.PROGRAMACION);
        libro.addPagina(new Pagina("Patron Singleton"))
                .addPagina(new Pagina("Patron Observador"))
                .addPagina(new Pagina("Patron Factory"))
                .addPagina(new Pagina("Patron Composite"))
                .addPagina(new Pagina("Patron Fascade"));


        Informe informe = new Informe("Estudio sobre microservicios", "Martin Fowler", "James");

        imprimir(cv);
        imprimir(informe);
        imprimir(libro);
        System.out.println(libro.imprimirSaludo());



    }

    public static void imprimir(Imprimible imprimible){
        System.out.println(imprimible.imprimir());
    }
}
