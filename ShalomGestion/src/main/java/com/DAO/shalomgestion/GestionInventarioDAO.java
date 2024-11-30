package com.DAO.shalomgestion;

import com.Model.shalomgestion.Destino;
import com.Model.shalomgestion.GestionInventario;
import com.Model.shalomgestion.Inventario;
import com.Model.shalomgestion.Producto;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GestionInventarioDAO {

    private static final String obtenerTodos_query = """
        SELECT gi.id, gi.cantidad, gi.estado_producto, gi.descripcion,
               gi.fecha_entrada, gi.fecha_salida_max, gi.tiempo_excedente,
               p.id AS producto_id, p.nombre AS producto_nombre,
               p.descripcion AS producto_descripcion, p.peso AS producto_peso,
               p.medidas AS producto_medidas, p.precio AS producto_precio,
               i.nombre AS inventario_nombre, i.ubicacion AS inventario_ubicacion,
               d.departamento AS destino_departamento,
               d.ciudad AS destino_ciudad, d.direccion AS destino_direccion
        FROM gestion_inventario gi
        JOIN producto p ON gi.producto_id = p.id
        JOIN inventario i ON gi.inventario_id = i.id
        JOIN destino d ON gi.destino_id = d.id
    """;

    // Constructor sin parámetros
    public GestionInventarioDAO() {
        // No es necesario inicializar la conexión aquí
    }

    // Método para obtener todos los registros de gestión de inventario
    public List<GestionInventario> obtenerTodos(Connection connection) {
        List<GestionInventario> lista = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(obtenerTodos_query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                lista.add(mapearResultado(rs));
            }
        } catch (SQLException e) {
            System.err.println("Error al ejecutar la consulta: " + e.getMessage());
        }
        return lista;
    }

    
    // Método para buscar por nombre del producto
    public List<GestionInventario> buscarPorProducto(Connection connection, String productoNombre, String estadoProducto) {
        String query = obtenerTodos_query + " WHERE p.nombre LIKE ? AND gi.estado_producto LIKE ?";
        List<GestionInventario> lista = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, "%" + productoNombre + "%");
            stmt.setString(2, "%" + estadoProducto + "%");
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    lista.add(mapearResultado(rs));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar por producto: " + e.getMessage());
        }
        return lista;
    }


    public List<GestionInventario> buscarPorEstado(Connection connection, String estado) {
        String query = obtenerTodos_query + " WHERE gi.estado_producto LIKE ?";
        List<GestionInventario> lista = new ArrayList<>();
    
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, "%" + estado + "%");
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        lista.add(mapearResultado(rs));
                    }
                }
        } catch (SQLException e) {
            System.err.println("Error al buscar por estado: " + e.getMessage());
        }
    
        return lista;
    }
    
    private String obtenerEstadoPorId(Connection connection, int id) {
        String query = "SELECT estado_producto FROM gestion_inventario WHERE id = ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("estado_producto");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Si no se encuentra el estado, devolver null
    }
    
    public boolean modificarEstado(Connection connection, int id) {
        // Primero obtenemos el estado actual del registro
        String estadoActual = obtenerEstadoPorId(connection, id);

        // Determinamos el nuevo estado en base al estado actual
        String nuevoEstado = "Enviado"; // Si está en "En almacén", lo cambiaremos a "Enviado"
        if ("Enviado".equals(estadoActual)) {
            nuevoEstado = "En almacén"; // Si está en "Enviado", lo cambiaremos a "En almacén"
        }

        // Realizamos la actualización en la base de datos
        String query = "UPDATE gestion_inventario SET estado_producto = ? WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, nuevoEstado); // Establecer el nuevo estado
            stmt.setLong(2, id); // Establecer el ID del registro

            int filasActualizadas = stmt.executeUpdate();
            return filasActualizadas > 0; // Si se actualizó al menos una fila, devuelve true
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // En caso de error, devuelve false
        }
    }
    
    


    // Método para mapear el resultado del ResultSet a un objeto GestionInventario
    private GestionInventario mapearResultado(ResultSet rs) throws SQLException {
        Producto producto = new Producto(
                rs.getString("producto_id"),
                rs.getString("producto_nombre"),
                rs.getString("producto_descripcion"),
                rs.getDouble("producto_peso"),
                rs.getString("producto_medidas"),
                rs.getDouble("producto_precio"),
                null
        );

        Inventario inventario = new Inventario(
                0,
                rs.getString("inventario_nombre"),
                rs.getString("inventario_ubicacion")
        );

        Destino destino = new Destino(
                0,
                rs.getString("destino_departamento"),
                rs.getString("destino_ciudad"),
                rs.getString("destino_direccion")
        );

        LocalDate fechaEntrada = rs.getDate("fecha_entrada") != null ? rs.getDate("fecha_entrada").toLocalDate() : null;
        LocalDate fechaSalidaMaxima = rs.getDate("fecha_salida_max") != null ? rs.getDate("fecha_salida_max").toLocalDate() : null;

        return new GestionInventario(
                rs.getInt("id"),
                producto,
                inventario,
                destino,
                rs.getInt("cantidad"),
                rs.getString("descripcion"),
                fechaEntrada,
                fechaSalidaMaxima,
                rs.getInt("tiempo_excedente"),
                rs.getString("estado_producto")
        );
    }
}
