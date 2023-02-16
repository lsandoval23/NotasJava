package org.lsandoval.recursividad.ejemplo;

import org.lsandoval.recursividad.ejemplo.models.Componente;

public class EjemploRecursividad {

    public static void main(String[] args) {

        Componente pc = new Componente("Gabinete PC ATX");
        Componente poder = new Componente("Fuente Poder 700w");
        Componente placaMadre = new Componente("MainBoard Asus sockets AMD");
        Componente cpu = new Componente("Cpu AMD Ryzen 5 2800");
        Componente ventilador = new Componente("Ventilador CPU");
        Componente disipador = new Componente("Disipador");
        Componente tv =  new Componente("Nvidia RTX 3080 8GB");
        Componente gpu = new Componente("Nvidia GPU RTX");
        Componente gpuRam = new Componente("4GB Ram");
        Componente gpuRam2 = new Componente("4GB Ram");
        Componente gpuVentiladores = new Componente("Ventiladores");
        Componente ram = new Componente("Memoria Ram 32GB");
        Componente ssd = new Componente("Disco SSD 2T");

        // cpu esta formado por ventilador y disipador
        cpu.addComponente(ventilador)
                .addComponente(disipador);
        // tv esta formando por gpu, ram y ventiladores
        tv.addComponente(gpu)
                .addComponente(gpuRam)
                .addComponente(gpuRam2)
                .addComponente(gpuVentiladores);
        // la placa madre esta formada por cpu, tv, memoria y disco duro
        placaMadre.addComponente(cpu)
                .addComponente(tv)
                .addComponente(ram)
                .addComponente(ssd);
        pc.addComponente(poder)
                .addComponente(placaMadre)
                .addComponente(new Componente("Teclado"))
                .addComponente(new Componente("Mouse"));

        metodoRecursivo(pc, 0);

    }

    // El metodo recursivo es el que permite iterar sobre  el arbol de componentes
    public static void metodoRecursivo(Componente c, int nivel) {

        System.out.println("\t".repeat(nivel) + c.getNombre());
        if(c.tieneHijos()){
            for(Componente hijo: c.getHijos()){
                metodoRecursivo(hijo, nivel + 1);
            }
        }
    }
}
