package org.lsandoval.poointerfaces.repositorio;

import org.lsandoval.poointerfaces.modelo.Cliente;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// Equivalente al DAO implementation que se usa en Colossus, por defecto la libreria CRUD(Framework de persistencia)
// repositorio da la mayoria de
// caracteristicas de sql, si se quiere algo más especifico se usa un implementation


// Ahora ClienteListRepositorio implementa una sola interfaz que hereda sus metodos de las demas interfaces
public class ClienteListRepositorio implements OrdenablePaginableCrudRepositorio{


    // Atributo
    private List<Cliente> datasource;

    // Constructor
    public ClienteListRepositorio() {
        this.datasource = new ArrayList<>();
    }

    // Implementacion
    @Override
    public List<Cliente> listar() {
        return datasource;
    }

    @Override
    public Cliente porId(Integer id) {
        Cliente resultado = null;
        for(Cliente cli: datasource){
            if( cli.getId() != null && cli.getId().equals(id)){
                resultado = cli;
                break;
            }
        }
        return resultado;
    }

    @Override
    public void crear(Cliente cliente) {
        this.datasource.add(cliente);
    }

    @Override
    public void editar(Cliente cliente) {
        Cliente c = this.porId(cliente.getId());
        c.setNombre(cliente.getNombre());
        c.setApellido(cliente.getApellido());

    }

    @Override
    public void eliminar(Integer id) {
        this.datasource.remove(this.porId(id));  // Remove metodo de la clase ArrayList, este usa el metodo equals internamente
                                                 // que se sobreescribe en Cliente

    }

    // Paginable
    @Override
    public List<Cliente> listar(int desde, int hasta) {
        return datasource.subList(desde, hasta);
    }

    //Ordenable
    @Override
    public List<Cliente> listar(String campo, Direccion dir) {
        // Cuando se ordena, no se tiene que modificar el datasource. Por eso se crea una copia del datasource sobre el que
        // se haran los cambios
        List<Cliente> listaOrdenada= new ArrayList<>(this.datasource);

        // Metodos de implementacion optimizados

        // 1. Implementando un metodo ordenar para reutilizar el switch en la clase anonima Comparator

        /*
        listaOrdenada.sort(new Comparator<Cliente>() {
            @Override
            public int compare(Cliente a, Cliente b) {
                int resultado = 0;
                if (dir == Direccion.ASC){
                   resultado = this.ordenar(a,b);
                } else if (dir == Direccion.DESC){
                    resultado = this.ordenar(b,a);
                }
                return resultado;
            }

            private int ordenar(Cliente a, Cliente b) {

                int resultado = 0;
                switch (campo){
                    case "id" ->
                            resultado = a.getId().compareTo(b.getId());
                    case "nombre" ->
                            resultado = a.getNombre().compareTo(b.getNombre());
                    case "apellido" ->
                            resultado = a.getApellido().compareTo(b.getApellido());
                }
                return  resultado;
            }
        });

         */


        // 2. Con una expression lambda y un metodo de la clase o implementado dentro de la interfaz ordenable
        listaOrdenada.sort((a,b) -> {
            int resultado = 0;
            if (dir == Direccion.ASC){
                resultado = ordenar(campo, a,b);
            } else if (dir == Direccion.DESC){
                resultado = ordenar(campo, b,a);
            }
            return resultado;
        });


        // Metodo Original

        /*
        listaOrdenada.sort((a,b) -> {
            int resultado = 0;
            if (dir == Direccion.ASC){
                switch (campo){
                    case "id" ->
                        resultado = a.getId().compareTo(b.getId());
                    case "nombre" ->
                        resultado = a.getNombre().compareTo(b.getNombre());
                    case "apellido" ->
                        resultado = a.getApellido().compareTo(b.getApellido());
                }
            } else if (dir == Direccion.DESC){
                switch (campo){
                    case "id" ->
                        resultado = b.getId().compareTo(a.getId());
                    case "nombre" ->
                        resultado = b.getNombre().compareTo(a.getNombre());
                    case "apellido" ->
                        resultado = b.getApellido().compareTo(a.getApellido());
                }
            }
            return resultado;
        }); */

        return listaOrdenada;
    }


    // Metodo de la clase usado para el caso 2 de la implementacion de ordenable.

    // 1. El metodo puede estar como un metodo estatico dentro de la clase que implementa a la interfaz, o
    // dentro de la interfaz

    /*
    private static int ordenar(String campo, Cliente a, Cliente b) {

        int resultado = 0;
        switch (campo) {
            case "id" -> resultado = a.getId().compareTo(b.getId());
            case "nombre" -> resultado = a.getNombre().compareTo(b.getNombre());
            case "apellido" -> resultado = a.getApellido().compareTo(b.getApellido());
        }
        return resultado;
    }

     */

}
