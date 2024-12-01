/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DAO.shalomgestion;

import com.Model.shalomgestion.Destino;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carlos
 */
public class DestinoDAO {

    public DestinoDAO() {

    }

    public List<Destino> obtenerDestinos(Connection connection) throws Exception {
        String query = "SELECT id, departamento, ciudad, direccion FROM destino";
        List<Destino> destinos = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                
                int id = rs.getInt("id");
                String departamento = rs.getString("departamento");
                String ciudad = rs.getString("ciudad");
                String direccion = rs.getString("direccion");
               
                destinos.add(new Destino(id, departamento, ciudad, direccion));
            }
        } catch (Exception e) {
            throw new Exception("Error al obtener destinos: " + e.getMessage());
        }
        return destinos;
    }
}
