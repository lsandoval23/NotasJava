package org.lsandoval.patrones.decorator.decoradores;

import java.util.Base64;


// Decorador concreto extiende al decorador base
public class EncryptionDecorator extends  DataSourceDecorator{

    // Delega la inicializacion del componente envueto a la clase padre
    public EncryptionDecorator(DataSource source) {
        super(source);
    }

    // Sobreescribe los metodos para añadir funcionalidades básicas, ya sea antes o después de llamar a los metodos
    // base del componente envuelto.
    @Override
    public void writeData(String data) {
        super.writeData(encode(data));
    }

    @Override
    public String readData() {
        return decode(super.readData());
    }

    private String encode(String data){
        byte[] result = data.getBytes();
        for (int i = 0; i < result.length; i++){
            result[i] += (byte) 1;
        }

        return Base64.getEncoder().encodeToString(result);
    }

    private String decode(String data) {
        byte[] result = Base64.getDecoder().decode(data);
        for (int i = 0; i < result.length; i++) {
            result[i] -= (byte) 1;
        }
        return new String(result);
    }
}
