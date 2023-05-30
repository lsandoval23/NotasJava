package org.lsandoval_jdbc2.repositorio;

import java.util.List;

public interface Repositorio<T>{

    List<T> listar();
    T porId(Long id);
    void guardar(T t);
    void eliminar(Long id);


}
