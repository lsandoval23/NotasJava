package org.lsandoval;

import org.lsandoval.modelo.Producto;
import org.lsandoval.repositorio.ProductoRepositorioImpl;
import org.lsandoval.repositorio.Repositorio;
import org.lsandoval.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class EjemploJdbcDelete {
    public static void main(String[] args) {

        // Nos aseguramos de cerrar la conexion de base de datos en este bloque de programa, en los repositorios
        // no se están cerrando.

        try (Connection conn = ConexionBaseDatos.getInstance()){

            /* findAll */
            System.out.println("===== listar =====");

            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            repositorio.listar().forEach(System.out::println);

            System.out.println("============= Eliminar producto =============");
            repositorio.eliminar(3L);
            System.out.println("Producto eliminado con éxito");

            System.out.println("===== listar =====");
            repositorio.listar().forEach(System.out::println);



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
