package org.lsandoval.poointerfaces;

import org.lsandoval.poointerfaces.modelo.Cliente;
import org.lsandoval.poointerfaces.repositorio.ClienteListRepositorio;
import org.lsandoval.poointerfaces.repositorio.CrudRepositorio;
import org.lsandoval.poointerfaces.repositorio.Direccion;

import java.util.List;

public class EjemploRepositorio {
    public static void main(String[] args) {

        ClienteListRepositorio repo = new ClienteListRepositorio();
        repo.crear(new Cliente("Jano", "Perez"));
        repo.crear(new Cliente("Bea", "Gonzales"));
        repo.crear(new Cliente("Luci", "Martinez"));
        repo.crear(new Cliente("Andres", "Guzman"));

        List<Cliente> clientes = repo.listar();
        clientes.forEach(c -> System.out.println(c));

        System.out.println("=========== paginable ==============");

        List<Cliente> paginable = repo.listar(0, 3);
        paginable.forEach(c -> System.out.println(c));

        System.out.println("=========== ordenable ==============");

        List<Cliente> ordenable = repo.listar("apellido", Direccion.ASC);
        ordenable.forEach(c -> System.out.println(c));

        System.out.println("=========== editar ==============");
        Cliente beaActualizar = new Cliente("Bea", "Mena");
        beaActualizar.setId(2);
        repo.editar(beaActualizar);
        Cliente bea = repo.porId(2);
        System.out.println(bea);

        System.out.println("=========== eliminar ==============");
        repo.eliminar(2);
        repo.listar().forEach(System.out::println);

    }
}
