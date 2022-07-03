package org.lsandoval.poointerfaces.imprenta;

import org.lsandoval.poointerfaces.imprenta.modelo.Curriculo;
import org.lsandoval.poointerfaces.imprenta.modelo.Hoja;
import org.lsandoval.poointerfaces.imprenta.modelo.Informe;

public class EjemploImprenta {
    public static void main(String[] args) {

        Curriculo cv = new Curriculo("Resumen laboral....", "John Doe", "Ingeniero de sistemas");
        cv.addExperiencia("Java");
        cv.addExperiencia("Oracle DBA").addExperiencia("Spring Framework")
                .addExperiencia("Desarrollador fullstack").addExperiencia("Angular");

        Informe informe = new Informe("Estudio sobre microservicios", "Martin Fowler", "James");

        imprimir(cv);
        imprimir(informe);


    }

    public static void imprimir(Hoja imprimible){
        System.out.println(imprimible.imprimir());
    }
}
