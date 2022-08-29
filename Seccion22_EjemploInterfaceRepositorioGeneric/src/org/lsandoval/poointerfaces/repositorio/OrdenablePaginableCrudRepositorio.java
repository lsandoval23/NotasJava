package org.lsandoval.poointerfaces.repositorio;

// Dentro de los repositorios se puede tener herencia multiple, asi de esta forma una clase puede implementar a multiples repositorios
// usando la clase en la jerarquia mas baja
public interface OrdenablePaginableCrudRepositorio<T> extends CrudRepositorio<T>, OrdenableRepositorio<T>, PaginableRepositorio<T>,
                                                             ContableRepositorio{

}
