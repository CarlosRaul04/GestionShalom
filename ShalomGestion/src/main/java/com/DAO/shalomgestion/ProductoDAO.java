/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DAO.shalomgestion;

import com.Model.shalomgestion.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Carlos
 */
public class ProductoDAO {
    // Método para obtener un producto por su ID
    public Producto obtenerProductoPorNombre(Connection connection, String nombre) {
        String query = "SELECT * FROM producto WHERE nombre like ?";  // La consulta SQL

        // Ejecutamos la consulta
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, nombre);  // Establecemos el parámetro en la consulta

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // Si se encuentra un producto, lo mapeamos y lo devolvemos
                    return mapearProducto(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();  // En caso de error, mostramos el error
        }
        return null;  // Si no se encuentra el producto, devolvemos null
    }

    // Método para mapear el resultado de la consulta a un objeto Producto
    private Producto mapearProducto(ResultSet rs) throws SQLException {
        // Mapeamos los resultados de la consulta a un objeto Producto
        return new Producto(
            rs.getString("id"),  // Asumimos que "id" es del tipo String en la clase Producto
            rs.getString("nombre"),
            rs.getString("descripcion"),
            rs.getDouble("peso"),
            rs.getString("medidas"),
            rs.getDouble("precio"),
            rs.getString("estado")
        );
    }
}
