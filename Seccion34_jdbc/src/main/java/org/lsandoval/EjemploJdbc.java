package org.lsandoval;

import org.lsandoval.modelo.Producto;
import org.lsandoval.repositorio.ProductoRepositorioImpl;
import org.lsandoval.repositorio.Repositorio;
import org.lsandoval.util.ConexionBaseDatos;

import java.sql.*;

public class EjemploJdbc {
    public static void main(String[] args) {

        // Nos aseguramos de cerrar la conexion de base de datos en este bloque de programa, en los repositorios
        // no se están cerrando.

        try (Connection conn = ConexionBaseDatos.getInstance()){

            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            repositorio.listar().forEach(p -> System.out.println(p.getNombre()));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
