package org.lsandoval.patrones.decorator.decoradores;

// Decorador base, implementa la misma interfaz que un componente concreto
public class DataSourceDecorator implements DataSource{

    // Tiene un atributo wrapee (componente envuelto) que será un componente concreto
    private DataSource wrapee;

    // El wrapee se inicializa en el constructor
    public DataSourceDecorator(DataSource source) {
        this.wrapee = source;
    }

    // El decorador base delega  el trabajo al componente envuelto, en los decoradores concretos se añaden las funcionalidades
    // extra
    @Override
    public void writeData(String data) {
        wrapee.writeData(data);
    }

    @Override
    public String readData() {
        return wrapee.readData();
    }
}
