/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Services.shalomgestion;

import com.DAO.shalomgestion.UsuarioDAO;
import com.Model.shalomgestion.Usuario;
import com.utils.shalomgestion.conexionBD;
import java.sql.Connection;

/**
 *
 * @author Carlos
 */
public class LoginService {
    
    private final UsuarioDAO usuarioDAO;
    
    public LoginService() {
        this.usuarioDAO = new UsuarioDAO();
    }
    
    public Usuario iniciarSesion(String correo, String contrasena){
        try(Connection connection = conexionBD.getConnection()){
            Usuario usuario = usuarioDAO.verificarCredenciales(correo, contrasena, connection);
            
            if (usuario != null) {
                
                System.out.println("Bienvenido" + usuario.getNombre() + "! Iniciaste sesión correctamente" );
                return usuario;
                
            } else {
                 System.out.println("Credenciales inválidas. Por favor, verifica tu correo y contraseña.");
            }
        } catch (Exception e) {
             System.out.println("Error durante el inicio de sesión: " + e.getMessage());
        }
        return null;
    }
    
}
