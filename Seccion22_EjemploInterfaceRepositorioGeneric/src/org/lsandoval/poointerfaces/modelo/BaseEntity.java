package org.lsandoval.poointerfaces.modelo;


// Se crea la clase BaseEntity que es la clase base para todos los demas modelos, esta da los metodos para setear y
// obtener el ID ya que es un atributo comun a todas las clases

import java.util.Objects;

public class BaseEntity {

    // Atributos
    protected  Integer id;
    private static int ultimoId;

    // En el constructor se aumenta el id en 1 cada que se crea un nuevo objeto
    public BaseEntity(){
        this.id = ++ultimoId;
    }

    // Getter y Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity base = (BaseEntity) o;

        return Objects.equals(id, base.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
