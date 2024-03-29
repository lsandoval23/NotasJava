package org.lsandoval.generics;

import org.lsandoval.poointerfaces.modelo.Cliente;
import org.lsandoval.poointerfaces.modelo.ClientePremium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemploGenericos {
    public static void main(String[] args) {

        /** Ejemplo del  uso de genericos, el operador '<>' diamante, permite que se especifique con
         * que tipo de instancias se encuentran dentro de la lista, de esta forma no es necesario usar
         * casting, los metodos dentro de arrayList saben que tipo de dato se devuelve. El usar casting también
         * puede llevar a errores, ya que se puede hacer un mal casting que genera un error en tiempo de ejecucion **/

        /*

        List clientes = new ArrayList<>();
        clientes.add(new Cliente("Andres", "Guzman"));

        Cliente andres = (Cliente) clientes.iterator().next();

         */

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("Andres", "Guzman"));

        Cliente andres = clientes.iterator().next();


        Cliente[] clientesArray = {new Cliente("Andres", "Guzman"), new Cliente("Luci", "Martinez")};
        Integer[] enterosArray = {1,2,3};

        List<Cliente> clienteList = fromArrayToList(clientesArray);
        List<Integer> enterosList = fromArrayToList(enterosArray);

        clienteList.forEach(System.out::println);
        enterosList.forEach(System.out::println);

        System.out.println("============ Sobrecarga del metodo ===========");
        List<String> nombres = fromArrayToList(new String[]{"Andres", "Luis", "Luci", "Bea", "John"}, enterosArray);
        nombres.forEach(System.out::println);

        // El metodo fromArrayToList hace el llamado al que tiene la restriccion <T extends Cliente & Comparable<T>>
        // y la nueva clase ClientePremium cumple estas condiciones
        List<ClientePremium> clientePremiumList = fromArrayToList(
                new ClientePremium[]{new ClientePremium("Paco", "Fernandez")});


        System.out.println("============ Uso de Wildcart ================");

        imprimirClientes(clientes);
        imprimirClientes(clienteList);
        imprimirClientes(clientePremiumList);
        imprimirLista(clientePremiumList);

        System.out.println("============ Maximo de tres objetos usando genericos ===========");

        // Las clases wrapper Integer, Double y String implementan a la interfaz Comparable dentro de su implementacion
        System.out.println("Maximo de 1, 9 y 4 es: " + maximo(1, 9, 4));
        System.out.println("Maximo de 3.9, 11.6, 7.78 es: " + maximo(3.9, 11.6, 7.78));
        System.out.println("Maximo de zanahora, arandanos, manzana es: "
                + maximo("zanahora", "arandano", "manzana"));

    }

    /*
        // Funcion que permite convertir un array de Cliente en una lista, observamos que solo se limita a convertir
        // elementos del tipo cliente

    public static List<Cliente> fromArrayToList(Cliente[] c){
        return Arrays.asList(c);
    }
    */

    // Funcion usando genericos, ahora acepta cualquier tipo de instancia
    public static <T> List<T> fromArrayToList(T[] c){
        return Arrays.asList(c);
    }

    // Bounded Generics, permite restringir que tipo de clase se puede usar en los argumentos genericos
    // En este caso, limitamos como parametros a todas las clases hijas de Number.

    public static <T extends Number> List<T> fromArrayToList(T[] c){
        return Arrays.asList(c);
    }

    // Se restringen como argumento generico a aquellas clases que hereden de cliente e implementen la interfaz Comparable
    public static <T extends Cliente & Comparable<T>> List<T> fromArrayToList(T[] c){
        return Arrays.asList(c);
    }


    // Otra funcion generica que acepta dos parametros genericos, transforma en lista a un array y el otro lo imprime
    public static <T, G> List<T> fromArrayToList(T[] c, G[] g){
        for (G elemento: g){
            System.out.println(elemento);
        }
        return Arrays.asList(c);
    }

    // Wildcart o comodin, permite que se pueda imprimir una lista de clientes o cualquier clase subyacente restringiendo
    // el metodo para listas de cierto tipo.

    /*
    *   public static void imprimirClientes(List<Cliente> clientes)
    *
    *   En este caso, si quisiera imprimir la lista de clientes premium no lo permitiria, ya que la lista de clientes
    *   no se relaciona con una lista de clientes premium
    *
    * */
    public static void imprimirClientes(List<? extends Cliente> clientes){
        clientes.forEach(System.out::println);
    }

    // En este caso, observamos que el wildcart solo, nos permite imprimir cualquier Lista.
    public static void imprimirLista(List<?> list){
        list.forEach(System.out::println);
    }

    // El metodo generico permite comparar 3 objetos de clases que implementen la interfaz comparable (Observar que
    // extends aplica para interfaces y clases en los parámetros genéricos) y calcula el mayor.
    // Para strings,
    public static <T extends Comparable<T>> T maximo(T a, T b, T c){
        T max = a;
        if (b.compareTo(max) > 0){
            max = b;
        }

        if (c.compareTo(max) > 0){
            max = c;
        }
        return max;
    }







}
