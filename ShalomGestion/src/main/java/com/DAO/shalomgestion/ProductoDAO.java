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

    
    public String generarNuevoIdProducto(Connection connection) {
        String query = "SELECT MAX(id) AS ultimo_id FROM producto";

        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                String ultimoId = rs.getString("ultimo_id");
                if (ultimoId != null) {
                    int nuevoIdNumerico = Integer.parseInt(ultimoId.substring(1)) + 1;  // Extraemos el número y lo incrementamos
                    return String.format("P%05d", nuevoIdNumerico);  // Formateamos como P00001, P00002, etc.
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Mostramos el error si ocurre
        }
        return "P00001";  // Si no hay productos, devolvemos el primer ID
    }

    // Nuevo método: Crear un producto
    public Producto crearProducto(Connection connection, Producto producto) {
        String nuevoId = generarNuevoIdProducto(connection); // Generamos automáticamente el ID
        String query = "INSERT INTO producto (id, nombre, descripcion, peso, medidas, precio, estado) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, nuevoId);  // Usamos el nuevo ID generado
            stmt.setString(2, producto.getNombre());
            stmt.setString(3, producto.getDescripcion());
            stmt.setDouble(4, producto.getPeso());
            stmt.setString(5, producto.getMedidas());
            stmt.setDouble(6, producto.getPrecio());
            stmt.setString(7, producto.getEstado());

            int filasAfectadas = stmt.executeUpdate();
            if (filasAfectadas > 0) {
                // Actualizar el ID del producto y devolver la instancia
                producto.setId(nuevoId);
                return producto;
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Mostramos el error si ocurre
        }

        return null; // Si ocurre un error o no se inserta, devolvemos null
    }
    
}
