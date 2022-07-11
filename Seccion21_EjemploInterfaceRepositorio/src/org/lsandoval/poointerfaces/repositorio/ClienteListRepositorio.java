package org.lsandoval.poointerfaces.repositorio;

import org.lsandoval.poointerfaces.modelo.Cliente;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// Equivalente al DAO implementation que se usa en Colossus, por defecto la libreria CRUD(Framework de persistencia)
// repositorio da la mayoria de
// caracteristicas de sql, si se quiere algo más especifico se usa un implementation

public class ClienteListRepositorio implements CrudRepositorio, PaginableRepositorio, OrdenableRepositorio{


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
            if(cli.getId().equals(id)){
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
        datasource.sort((a,b) -> {
            int resultado = 0;
            if (dir == Direccion.ASC){
                switch (campo){
                    case "id":
                        resultado = a.getId().compareTo(b.getId());
                    case "nombre":
                        resultado = a.getNombre().compareTo(b.getNombre());
                    case "apellido":
                        resultado = a.getApellido().compareTo(b.getApellido());
                }
            } else if (dir == Direccion.DESC){
                switch (campo){
                    case "id":
                        resultado = b.getId().compareTo(a.getId());
                    case "nombre":
                        resultado = b.getNombre().compareTo(a.getNombre());
                    case "apellido":
                        resultado = b.getApellido().compareTo(a.getApellido());
                }
            }
            return resultado;
        });

        return datasource;
    }
}
