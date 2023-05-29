package org.lsandoval.repositorio;

import org.lsandoval.modelo.Categoria;
import org.lsandoval.modelo.Producto;
import org.lsandoval.util.ConexionBaseDatos;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepositorioImpl implements Repositorio<Producto>{

    private Connection getConnection() throws SQLException {
        return ConexionBaseDatos.getInstance();
    }

    @Override
    public List<Producto> listar() {
        List<Producto> productos = new ArrayList<>();

        // Cambiamos el query para que tambien consulte sobre el campo de categoria usando joins
        try (Statement stmt = getConnection().createStatement();
             ResultSet rs = stmt.executeQuery("SELECT p.*, c.nombre as categoria FROM productos as p " +
                     "inner join categorias as c ON (p.categoria_id = c.id)")){

            while (rs.next()){
                Producto p = crearProducto(rs);
                productos.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productos;
    }

    @Override
    public Producto porId(Long id) {

        Producto producto = null;
        try (PreparedStatement stmt = getConnection().prepareStatement("SELECT p.*, c.nombre as categoria FROM productos as p " +
                "inner join categorias as c ON (p.categoria_id = c.id) WHERE p.id = ?")){

            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                producto = crearProducto(rs);
            }
            // No podemos usar el rs dentro del try ya que previamente requiere que se setee el parametro del statement.
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return producto;
    }

    @Override
    public void guardar(Producto producto) {

        String query;
        if (producto.getId() != null && producto.getId() > 0){
            query = "UPDATE productos SET nombre=?, precio=?, categoria_id=? WHERE id=?";
        }else {
            query = "INSERT INTO productos(nombre, precio, categoria_id, fecha_registro) VALUES(?,?,?,?)";
        }

        try (PreparedStatement stmt = getConnection().prepareStatement(query)){

            stmt.setString(1, producto.getNombre());
            stmt.setLong(2,producto.getPrecio());
            stmt.setLong(3, producto.getCategoria().getId());

            if (producto.getId() != null && producto.getId() > 0) {
                stmt.setLong(4, producto.getId());
            } else {
                stmt.setDate(4, new Date(producto.getFechaRegistro().getTime()));
            }
            stmt.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void eliminar(Long id) {
        String query = "DELETE FROM productos WHERE id = ?";
        try (PreparedStatement stmt = getConnection().prepareStatement(query)){

            stmt.setLong(1,id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Agregamos un constructor para la clase producto a partir del result set
    private static Producto crearProducto(ResultSet rs) throws SQLException {
        Producto p = new Producto();
        p.setId(rs.getLong("id"));
        p.setNombre(rs.getString("nombre"));
        p.setPrecio(rs.getInt("precio"));
        p.setFechaRegistro(rs.getDate("fecha_registro"));

        // Creamos la categoria (del query obtenemos la categoria y categoria_id como columnas)
        Categoria categoria = new Categoria();
        categoria.setId(rs.getLong("categoria_id"));
        categoria.setNombre(rs.getString("categoria"));

        // Asignamos el atributo
        p.setCategoria(categoria);

        return p;
    }
}
