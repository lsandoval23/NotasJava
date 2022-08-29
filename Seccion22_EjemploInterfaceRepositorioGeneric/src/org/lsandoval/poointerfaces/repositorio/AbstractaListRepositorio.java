package org.lsandoval.poointerfaces.repositorio;

import org.lsandoval.poointerfaces.modelo.BaseEntity;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractaListRepositorio<T extends BaseEntity> implements OrdenablePaginableCrudRepositorio<T> {

    protected List<T> datasource;

    public AbstractaListRepositorio(){
        this.datasource = new ArrayList<>();
    }

    // Se implementan metodos comunes para datasources de distintos elementos
    //      - total(), listar(), buscar porId, crear (añadir), eliminar, listar(desde, hasta)
    // Los demas metodos necesitan una implementacion mas especifica de acuerdo a los atributos especificos de cada clase
    // hija de abstractalistrepositorio: editar, listar por atributo.


    @Override
    public int total() {
        return this.datasource.size();
    }

    @Override
    public List<T> listar() {
        return this.datasource;
    }


    // Que el parametro generico extienda a la clase BaseEntity permite que el parametro generico T tenga los getters y
    // setters de id
    @Override
    public T porId(Integer id) {
        T resultado = null;
        for (T t: datasource){
            if (t.getId() != null && t.getId().equals(id)){
                resultado = t;
                break;
            }
        }

        return resultado;
    }

    @Override
    public void crear(T object) {
        this.datasource.add(object);
    }


    @Override
    public void eliminar(Integer id) {
        this.datasource.remove(this.porId(id));
    }


    @Override
    public List<T> listar(int desde, int hasta) {
        return this.datasource.subList(desde, hasta);
    }
}
