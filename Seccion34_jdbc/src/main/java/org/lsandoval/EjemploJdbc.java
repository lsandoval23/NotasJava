package org.lsandoval;

import org.lsandoval.util.ConexionBaseDatos;

import java.sql.*;

public class EjemploJdbc {
    public static void main(String[] args) {

        // Usamos un bloque try con uso de recursos para asegurarnos de que las conexiones a la base de datos
        // se cierren así ocurran excepciones en el transcurso de la ejecucion

        try (Connection conn = ConexionBaseDatos.getInstance();
             Statement stmt = conn.createStatement();
             ResultSet result = stmt.executeQuery("SELECT * FROM productos")) {

            // Dentro del objeto result se obtiene un puntero a cada registro que se obtuvo de la consulta.
            while (result.next()){
                System.out.print(result.getInt("id"));
                System.out.print("|");
                System.out.print(result.getString("nombre"));
                System.out.print("|");
                System.out.print(result.getInt("precio"));
                System.out.print("|");
                System.out.println(result.getDate("fecha_registro"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
