package org.lsandoval.poointerfaces;

import org.lsandoval.poointerfaces.modelo.Cliente;
import org.lsandoval.poointerfaces.repositorio.Direccion;
import org.lsandoval.poointerfaces.repositorio.OrdenablePaginableCrudRepositorio;
import org.lsandoval.poointerfaces.repositorio.excepciones.AccesoDatoException;
import org.lsandoval.poointerfaces.repositorio.excepciones.EscrituraAccesoDatoException;
import org.lsandoval.poointerfaces.repositorio.excepciones.LecturaAccesoDatoException;
import org.lsandoval.poointerfaces.repositorio.excepciones.RegistroDuplicadoAccesoDatoException;
import org.lsandoval.poointerfaces.repositorio.lista.ClienteListRepositorio;

import java.util.List;

public class EjemploRepositorio {
    public static void main(String[] args) {

        // Se aumentan los bloques try y catch para tratar las excepciones que se puedan lanzar por los metodos
        // crear, editar y eliminar

        try {
            OrdenablePaginableCrudRepositorio<Cliente> repo = new ClienteListRepositorio();
            repo.crear(new Cliente("Jano", "Perez"));
            repo.crear(new Cliente("Bea", "Gonzales"));
            repo.crear(new Cliente("Luci", "Martinez"));
            repo.crear(new Cliente("Andres", "Guzman"));

            // Creamos un objeto que tenga existente en el dataasource
            Cliente andres = new Cliente("Andrés", "Guzmán");
            andres.setId(4);

            // Esta opcion lanza una excepcion del tipo Registro Duplicado: Error con el objeto con id: 4 ya existe en el repositorio
            repo.crear(andres);

            System.out.println("=========== editar ==============");
            Cliente beaActualizar = new Cliente("Bea", "Mena");
            beaActualizar.setId(2);
            repo.editar(beaActualizar);
            Cliente bea = repo.porId(2);
            System.out.println(bea);

            System.out.println("=========== eliminar ==============");
            repo.eliminar(2);
            repo.listar().forEach(System.out::println);     // Luego de ordenable, cuando se lista, se mantiene el orden original.
            System.out.println("===== total ===== ");
            System.out.println("Total registros: " + repo.total());

        } catch(RegistroDuplicadoAccesoDatoException e){
            System.out.println("Registro Duplicado: " + e.getMessage());
            e.printStackTrace();
        } catch(LecturaAccesoDatoException e){
            System.out.println("Lectura: " + e.getMessage());
            e.printStackTrace();
        } catch(EscrituraAccesoDatoException e){
            System.out.println("Escritura: " + e.getMessage());
            e.printStackTrace();
        } catch(AccesoDatoException e){
            System.out.println("Generica: " + e.getMessage());
            e.printStackTrace();
        }


    }
}
