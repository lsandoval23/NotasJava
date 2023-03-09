package org.lsandoval.patrones.factory.productos;

public class WindowsCheckbox implements CheckBox{
    @Override
    public void paint() {
        System.out.println("Haz creado un WindowsCheckbox");
    }
}
