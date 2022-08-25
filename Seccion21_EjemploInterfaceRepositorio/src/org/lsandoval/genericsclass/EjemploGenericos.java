package org.lsandoval.genericsclass;

public class EjemploGenericos {

    public static void main(String[] args) {

        Camion<Animal> transporteCaballos = new Camion<>(5);
        transporteCaballos.add(new Animal("Peregrino", "Caballo"));
        transporteCaballos.add(new Animal("grillo", "Caballo"));
        transporteCaballos.add(new Animal("Tunquen", "Caballo"));
        transporteCaballos.add(new Animal("Topocalma", "Caballo"));
        transporteCaballos.add(new Animal("Longotoma", "Caballo"));


        // Si no se usara el parametro generico dentro de la clase la implementacion de este bucle for seria
        /*
        *   for(Object o: transMaquinas){
        *       Maquinaria m = (Maquinaria) o;
        *       System.out.println(m.getTipo());
        *   }
        *
        *   Seria necesario hacer un cast, ya que la lista en la clase Camion tiene elementos de tipo Object
        *   el cast lo hace propenso a fallas y errores en tiempo de ejecución.
        * */

        for(Animal a: transporteCaballos){
            System.out.println(a.getNombre() + " " + a.getTipo());
        }

        Camion<Maquinaria> transMaquinas = new Camion<>(3);
        transMaquinas.add(new Maquinaria("Bulldozer"));
        transMaquinas.add(new Maquinaria("Grúa Horquilla"));
        transMaquinas.add(new Maquinaria("Perforadora"));

        for (Maquinaria m: transMaquinas){
            System.out.println(m.getTipo());
        }

        Camion<Automovil> transAuto = new Camion<>(3);
        transAuto.add(new Automovil("Toyota"));
        transAuto.add(new Automovil("Mitsubishi"));
        transAuto.add(new Automovil("Chevrolet"));

        for (Automovil a: transAuto){
            System.out.println(a.getMarca());
        }
    }
}
