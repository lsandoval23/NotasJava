package org.lsandoval.poointerfaces.repositorio;

import org.lsandoval.poointerfaces.repositorio.excepciones.AccesoDatoException;

import java.util.List;


// Se implementa un argumento generico que permite aceptar clases aparte de clientes.
public interface CrudRepositorio<T> {

    List<T> listar();         // Listar todos los elementos
    T porId(Integer id) throws AccesoDatoException;      // Obtener un cliente por su id
    void crear(T object) throws AccesoDatoException;    // Insert into
    void editar(T object) throws AccesoDatoException;   // UPDATE
    void eliminar(Integer id) throws AccesoDatoException;      // DELETE

}
