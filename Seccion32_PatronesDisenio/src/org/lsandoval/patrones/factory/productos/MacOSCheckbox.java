package org.lsandoval.patrones.factory.productos;

public class MacOSCheckbox implements CheckBox{
    @Override
    public void paint() {
        System.out.println("Haz creado un MacOSCheckbox");
    }
}
