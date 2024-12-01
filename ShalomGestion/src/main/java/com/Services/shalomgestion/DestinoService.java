/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Services.shalomgestion;

import com.DAO.shalomgestion.DestinoDAO;
import com.Model.shalomgestion.Destino;
import com.utils.shalomgestion.conexionBD;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Carlos
 */
public class DestinoService {
    private DestinoDAO destinoDAO;
    
    public DestinoService(){
        this.destinoDAO = new DestinoDAO();
    }
    
    public List<Destino> obtenerDestinos(){
        
        List<Destino> destinos = null;
        
        try(Connection connection = conexionBD.getConnection()) {
            destinos = destinoDAO.obtenerDestinos(connection);
        } catch(Exception e){
            System.out.println("Error al buscar destinos: " + e.getMessage());
        }
        
        return destinos;
    }
    
    
    
    
}
