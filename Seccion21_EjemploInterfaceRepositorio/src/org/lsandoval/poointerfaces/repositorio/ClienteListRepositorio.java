package org.lsandoval.poointerfaces.repositorio;

import org.lsandoval.poointerfaces.modelo.Cliente;

import java.util.ArrayList;
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
        return null;
    }

    //Ordenable
    @Override
    public List<Cliente> listar(String campo, Direccion dir) {
        return null;
    }
}
