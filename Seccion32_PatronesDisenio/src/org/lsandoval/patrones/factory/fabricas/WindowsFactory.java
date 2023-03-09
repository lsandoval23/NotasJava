package org.lsandoval.patrones.factory.fabricas;

import org.lsandoval.patrones.factory.productos.Button;
import org.lsandoval.patrones.factory.productos.CheckBox;
import org.lsandoval.patrones.factory.productos.WindowsButton;
import org.lsandoval.patrones.factory.productos.WindowsCheckbox;

public class WindowsFactory implements GUIFactory{
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public CheckBox createCheckbox() {
        return new WindowsCheckbox();
    }
}
