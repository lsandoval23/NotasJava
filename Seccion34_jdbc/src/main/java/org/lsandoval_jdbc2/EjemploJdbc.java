package org.lsandoval_jdbc2;

import org.lsandoval_jdbc2.modelo.Categoria;
import org.lsandoval_jdbc2.modelo.Producto;
import org.lsandoval_jdbc2.repositorio.ProductoRepositorioImpl;
import org.lsandoval_jdbc2.repositorio.Repositorio;
import org.lsandoval_jdbc2.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class EjemploJdbc {
    public static void main(String[] args) {

        // No es necesario usar el bloque try para cerrar la conexion, ya que cada metodo de productoRepositorio lo hace.
        // Sin embargo, es necesario quitar la restriccion singleton ya que luego de llamar al metodo listar, se cierra la conexion
        // y se necesita instanciar una nueva conexion para llamar al siguiente metodo (porIDs)

        // Esto genera que cada que se llame a un metodo, se abra una conexion a la base de datos.

        Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
        System.out.println("============= listar =============");
        repositorio.listar().forEach(System.out::println);

        System.out.println("============= obtener por id =============");
        System.out.println(repositorio.porId(1L));

    }

}
