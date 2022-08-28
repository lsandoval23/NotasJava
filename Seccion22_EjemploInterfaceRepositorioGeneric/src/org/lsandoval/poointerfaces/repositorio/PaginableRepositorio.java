package org.lsandoval.poointerfaces.repositorio;

import org.lsandoval.poointerfaces.modelo.Cliente;

import java.util.List;

public interface PaginableRepositorio {

    List<Cliente> listar(int desde, int hasta);     // Seleccion usando un rango de id's

}
