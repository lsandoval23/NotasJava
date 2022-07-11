package org.lsandoval.poointerfaces.repositorio;

import org.lsandoval.poointerfaces.modelo.Cliente;
import java.util.List;

public interface OrdenableRepositorio {

    List<Cliente> listar(String campo, Direccion dir);   //SELECT WHERE ASC O DESC

}
