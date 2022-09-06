package org.lsandoval.pooexcepciones.ejemplo;

import javax.swing.*;

public class EjemploExcepciones {
    public static void main(String[] args) {

        Calculadora cal = new Calculadora();
        String numerador = JOptionPane.showInputDialog("Ingrese el numerador: ");
        String denominador = JOptionPane.showInputDialog("Ingrese el denominador");


        try {
            double division = cal.dividir(numerador, denominador);
            System.out.println("division = " + division);
        } catch (FormatoNumeroException e){
            System.out.println("Se detecto una excepcion:  "+ e.getMessage());
            e.printStackTrace(System.out);
        } catch (DivisionPorZeroException e){
            System.out.println("Se detecto una excepcion:  "+ e.getMessage());
            e.printStackTrace(System.out);
        }


        System.out.println("Continuamos con el flujo del programa a pesar de los errores");


    }
}
