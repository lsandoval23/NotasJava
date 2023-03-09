package org.lsandoval.patrones.factory;

import org.lsandoval.patrones.factory.fabricas.GUIFactory;
import org.lsandoval.patrones.factory.productos.Button;
import org.lsandoval.patrones.factory.productos.CheckBox;

// Usuario de una fabrica, observamos que no usamos alguna clase en concreto y se mantiene una logica
// generalizada
public class Application {

    private Button button;
    private CheckBox checkBox;

    public Application(GUIFactory factory){
        button = factory.createButton();
        checkBox = factory.createCheckbox();
    }

    public void paint() {
        button.paint();
        checkBox.paint();
    }

}
