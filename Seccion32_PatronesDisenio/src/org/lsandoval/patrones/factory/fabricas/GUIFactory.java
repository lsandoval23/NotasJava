package org.lsandoval.patrones.factory.fabricas;

import org.lsandoval.patrones.factory.productos.Button;
import org.lsandoval.patrones.factory.productos.CheckBox;


// Se tiene una fabrica abstracta para cada familia de productos
public interface GUIFactory {

    // La fabrica abstracta contiene los metodos de creacion de cada producto, las implementaciones concretas
    // de la fabrica abstracta implementaran estos metodos para cada variante.
    Button createButton();
    CheckBox createCheckbox();

}

