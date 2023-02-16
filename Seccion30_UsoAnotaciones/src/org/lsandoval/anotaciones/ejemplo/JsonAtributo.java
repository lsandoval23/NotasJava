package org.lsandoval.anotaciones.ejemplo;

// Anotacion que permite indicar que atributos seran transformados a un Json cuando se imprima un objeto

import java.lang.annotation.*;

@Documented                             // Para poder documentar
@Target(ElementType.FIELD)              // Indicamos que la anotacion va sobre un atributo
@Retention(RetentionPolicy.RUNTIME)     // Se procesa en tiempo de ejecucion
// @Inherited (Si la anotacion va sobre una clase, esta se extiende a las clases hijas)
public @interface JsonAtributo {
    String nombre() default "";
    boolean capitalizar() default false;
}
