package org.lsandoval.poointerfaces.repositorio;

import java.util.List;


// Se implementa un argumento generico que permite aceptar clases aparte de clientes.
public interface CrudRepositorio<T> {

    List<T> listar();         // Listar todos los elementos
    T porId(Integer id);      // Obtener un cliente por su id
    void crear(T object);    // Insert into
    void editar(T object);   // UPDATE
    void eliminar(Integer id);      // DELETE

}
