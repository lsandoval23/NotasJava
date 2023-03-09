package org.lsandoval.patrones.factory.productos;

// Las familias de productos estan agrupadas en una interfaz (Las implementaciones de Button seran para cada
// variante: Boton Windows, boton mac, boton linux, etc)
public interface Button {
    void paint();
}
