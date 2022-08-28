package org.lsandoval.poointerfaces.repositorio;

import org.lsandoval.poointerfaces.modelo.Cliente;

import java.util.List;


public interface CrudRepositorio {

    List<Cliente> listar();         // Listar todos los elementos
    Cliente porId(Integer id);      // Obtener un cliente por su id
    void crear(Cliente cliente);    // Insert into
    void editar(Cliente cliente);   // UPDATE
    void eliminar(Integer id);      // DELETE

}
