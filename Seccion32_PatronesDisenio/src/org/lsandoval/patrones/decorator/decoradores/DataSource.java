package org.lsandoval.patrones.decorator.decoradores;

// Interfaz que define las operaciones basicas que los decoradores pueden modificar.
public interface DataSource {
    void writeData(String data);
    String readData();

}
