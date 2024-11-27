/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Services.shalomgestion;

import com.DAO.shalomgestion.GestionInventarioDAO;
import com.Model.shalomgestion.GestionInventario;
import com.utils.shalomgestion.conexionBD;
import java.sql.Connection;
import java.util.List;
/**
 *
 * @author Carlos
 */
public class MenuService {
    private GestionInventarioDAO gestionInventarioDAO;

    public MenuService() {
        // Inicializamos el DAO sin pasarle la conexión al constructor
        this.gestionInventarioDAO = new GestionInventarioDAO();
    }
    
    public List<GestionInventario> obtenerTodosLosRegistros() {
        List<GestionInventario> registros = null;

        // Usamos try-with-resources para gestionar la conexión correctamente
        try (Connection connection = conexionBD.getConnection()) {
            // Pasamos la conexión al método obtenerTodos
            registros = gestionInventarioDAO.obtenerTodos(connection);
            System.out.println("Registros: " + registros);  // Asegúrate de ver la lista impresa en la consola
        } catch (Exception e) {
            System.out.println("Error al establecer la conexión o al obtener los registros: " + e.getMessage());
        }

        return registros;
    }
}
