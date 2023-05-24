package org.lsandoval;

import org.lsandoval.modelo.Producto;
import org.lsandoval.repositorio.ProductoRepositorioImpl;
import org.lsandoval.repositorio.Repositorio;
import org.lsandoval.util.ConexionBaseDatos;

import java.sql.*;
import java.util.Date;

public class EjemploJdbc {
    public static void main(String[] args) {

        // Nos aseguramos de cerrar la conexion de base de datos en este bloque de programa, en los repositorios
        // no se están cerrando.

        try (Connection conn = ConexionBaseDatos.getInstance()){

            /* findAll */
            System.out.println("===== listar =====");

            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            repositorio.listar().forEach(System.out::println);

            /* findOne */
            System.out.println("===== porId =====");
            System.out.println(repositorio.porId(2L));

            /* save */
            System.out.println("===== crear =====");

            Producto producto = new Producto();
            producto.setNombre("Teclado Mecanico");
            producto.setPrecio(300);
            producto.setFechaRegistro(new Date());

            repositorio.guardar(producto);
            System.out.println("Producto guardado");

            System.out.println("===== listar =====");
            repositorio.listar().forEach(System.out::println);

            /* update */
            System.out.println("===== update =====");

            Producto producto2 = new Producto();

            producto2.setId(3L);
            producto2.setNombre("Teclado Razer");
            producto2.setPrecio(800);

            repositorio.guardar(producto2);
            System.out.println("Producto editado");

            System.out.println("===== listar =====");
            repositorio.listar().forEach(System.out::println);

            /* delete */

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
