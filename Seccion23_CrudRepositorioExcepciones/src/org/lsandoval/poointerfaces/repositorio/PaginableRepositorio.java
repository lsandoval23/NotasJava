package org.lsandoval.poointerfaces.repositorio;

import java.util.List;

public interface PaginableRepositorio<T> {

    List<T> listar(int desde, int hasta);     // Seleccion usando un rango de id's

}
