/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DAO.shalomgestion;

import com.Model.shalomgestion.Destino;
import com.Model.shalomgestion.GestionInventario;
import com.Model.shalomgestion.Inventario;
import com.Model.shalomgestion.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author Carlos
 */
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
        JOIN destino d ON gi.destino_id = d.id;
    """; 

    // Constructor sin parámetros
    public GestionInventarioDAO() {
        // No es necesario inicializar la conexión aquí, ya que se pasará cuando se invoque el método
    }

    // Método para obtener todos los registros de gestión de inventario
    public List<GestionInventario> obtenerTodos(Connection connection) {
        List<GestionInventario> lista = new ArrayList<>();

        try (PreparedStatement stmt = connection.prepareStatement(obtenerTodos_query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                // Mapeo de los resultados a los objetos correspondientes
                Producto producto = new Producto(
                        rs.getString("producto_id"),
                        rs.getString("producto_nombre"),
                        rs.getString("producto_descripcion"),
                        rs.getDouble("producto_peso"),
                        rs.getString("producto_medidas"),
                        rs.getDouble("producto_precio")
                );

                Inventario inventario = new Inventario(
                        0, // ID predeterminado, ya que no se obtiene del resultado
                        rs.getString("inventario_nombre"),
                        rs.getString("inventario_ubicacion")
                );

                Destino destino = new Destino(
                        0, // ID predeterminado
                        rs.getString("destino_departamento"),
                        rs.getString("destino_ciudad"),
                        rs.getString("destino_direccion")
                );

                // Verificación de campos nulos para las fechas
                LocalDate fechaEntrada = rs.getDate("fecha_entrada") != null ? rs.getDate("fecha_entrada").toLocalDate() : null;
                LocalDate fechaSalidaMaxima = rs.getDate("fecha_salida_max") != null ? rs.getDate("fecha_salida_max").toLocalDate() : null;

                // Creación del objeto de Gestión de Inventario
                GestionInventario inventarioGestion = new GestionInventario(
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

                lista.add(inventarioGestion);
            }

        } catch (SQLException e) {
            System.err.println("Error al ejecutar la consulta: " + e.getMessage());
        }

        return lista;
    }
}