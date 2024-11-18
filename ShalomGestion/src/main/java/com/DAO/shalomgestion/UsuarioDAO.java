/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DAO.shalomgestion;

import com.Model.shalomgestion.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Carlos
 */
public class UsuarioDAO {
    
  private static final String InicioSesion_query = "SELECT * FROM usuario WHERE correo= ? AND contraseña = ?";  
  
  public Usuario verificarCredenciales(String correo, String contrasena, Connection connection) throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement(InicioSesion_query)) {
            stmt.setString(1, correo);
            stmt.setString(2, contrasena);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // Mapeo del resultado a un objeto Usuario
                    return new Usuario(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("correo"),
                        rs.getString("telefono"),
                        rs.getString("contraseña"),
                        rs.getString("rol")
                    );
                }
            }
            return null; // Credenciales inválidas
        } catch (SQLException e) {
            System.err.println("Error al verificar las credenciales: " + e.getMessage());
            throw e; // Re-lanza la excepción para que el controlador/servicio la maneje
        }
    }
}
