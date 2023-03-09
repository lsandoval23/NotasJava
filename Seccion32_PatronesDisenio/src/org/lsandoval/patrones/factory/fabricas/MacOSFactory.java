package org.lsandoval.patrones.factory.fabricas;

import org.lsandoval.patrones.factory.productos.Button;
import org.lsandoval.patrones.factory.productos.CheckBox;
import org.lsandoval.patrones.factory.productos.MacOSButton;
import org.lsandoval.patrones.factory.productos.MacOSCheckbox;

public class MacOSFactory implements GUIFactory{
    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public CheckBox createCheckbox() {
        return new MacOSCheckbox();
    }
}
