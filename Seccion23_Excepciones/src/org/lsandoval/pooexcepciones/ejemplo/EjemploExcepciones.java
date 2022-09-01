package org.lsandoval.pooexcepciones.ejemplo;

import javax.swing.*;

public class EjemploExcepciones {
    public static void main(String[] args) {

        String valor = JOptionPane.showInputDialog("Ingrese un valor: ");

        // Aquellas sentencias que puedan generar una excepcion, y no se encuentren dentro del bloque try
        // interrumpen el flujo del programa. Si se encuentran dentro del bloque try podemos implementar
        // alternativas para que no se detenga el programa.

        // Ambos tipos de excepciones (NumberFormatException, ArithmeticException) son hijas de la clase RuntimeException
        // y son excepciones no chequeadas, estas son ignoradas en tiempo de compilacion y aparecen en error en tiempo de ejecucion
        // a diferencia de las excepciones chequeadas que no son ignoradas por el compilador y te obligan a ponerlas en un bloque
        // try catch

        try {
            // Puede generar un NumberFormatException
            int divisor = Integer.parseInt(valor);
            // Puede generar un ArithmeticException
            int division = 10/divisor;
            System.out.println(division);

        // Se atrapan las excepciones en el orden en el que pueden aparecer para tener un orden
        } catch (NumberFormatException e){
            System.out.println("Se detecto una excepcion: Ingrese un numero de formato valido");
            main(args);
        } catch (ArithmeticException e){
            System.out.println("Se detecto una excepcion: No se puede dividir por cero");
            main(args);
        }

        System.out.println("Continuamos con el flujo del programa a pesar de los errores");


    }
}
