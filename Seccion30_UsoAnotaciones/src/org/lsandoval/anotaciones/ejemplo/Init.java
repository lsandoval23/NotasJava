package org.lsandoval.anotaciones.ejemplo;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
// Ahora esta anotacion ira sobre metodos
@Target(ElementType.METHOD)
public @interface Init {
}
