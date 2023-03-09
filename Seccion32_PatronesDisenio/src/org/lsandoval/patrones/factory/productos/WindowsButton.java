package org.lsandoval.patrones.factory.productos;

public class WindowsButton implements Button{
    @Override
    public void paint() {
        System.out.println("Haz creado un WindowsButton");
    }
}
