package org.lsandoval.patrones.factory.productos;

public class MacOSButton implements Button{
    @Override
    public void paint() {
        System.out.println("Haz creado un MacOSButton");
    }
}
