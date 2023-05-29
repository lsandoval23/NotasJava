package org.lsandoval;

import org.lsandoval.modelo.Categoria;
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

            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            System.out.println("============= listar =============");
            repositorio.listar().forEach(System.out::println);

            System.out.println("============= obtener por id =============");
            System.out.println(repositorio.porId(1L));

            System.out.println("============= insertar nuevo producto =============");

            Producto producto = new Producto();
            producto.setNombre("Teclado Razer mecánico");
            producto.setPrecio(550);
            producto.setFechaRegistro(new Date());

            // Solo necesitamos el categoria_id, ya que dentro del metodo guardar solo es usa eso.
            Categoria categoria = new Categoria();
            categoria.setId(3L);
            producto.setCategoria(categoria);

            repositorio.guardar(producto);
            System.out.println("Producto guardado con éxito");
            repositorio.listar().forEach(System.out::println);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
