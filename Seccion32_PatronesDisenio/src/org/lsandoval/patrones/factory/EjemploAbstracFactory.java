package org.lsandoval.patrones.factory;

import org.lsandoval.patrones.factory.fabricas.GUIFactory;
import org.lsandoval.patrones.factory.fabricas.MacOSFactory;
import org.lsandoval.patrones.factory.fabricas.WindowsFactory;
import org.lsandoval.patrones.factory.productos.Button;
import org.lsandoval.patrones.factory.productos.CheckBox;


public class EjemploAbstracFactory {

    // Configuramos el tipo de factory concreta que usaremos usando la clase cliente Application.
    private static Application configureApplication(){

        Application app;
        GUIFactory factory;
        String osName = System.getProperty("os.name").toLowerCase();

        if (osName.contains("mac")) {
            factory = new MacOSFactory();
        } else {
            factory = new WindowsFactory();
        }

        app = new Application(factory);
        return app;
    }

    public static void main(String[] args) {

        Application app = configureApplication();
        app.paint();

    }
}
