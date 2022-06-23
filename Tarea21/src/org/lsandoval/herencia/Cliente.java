package org.lsandoval.herencia;

public class Cliente extends Persona{

    private  Integer clienteId;

    public Cliente(String nombre, String apellido, String numeroFiscal, String direccion, Integer clienteId) {
        super(nombre, apellido, numeroFiscal, direccion);
        this.clienteId = clienteId;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    @Override
    public String toString() {
        return "Cliente{\n" +
                super.toString() +
                "clienteId=" + clienteId +
                '}';
    }
}
