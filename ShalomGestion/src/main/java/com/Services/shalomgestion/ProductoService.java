/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Services.shalomgestion;

import com.DAO.shalomgestion.ProductoDAO;
import com.Model.shalomgestion.Producto;
import com.utils.shalomgestion.conexionBD;
import java.sql.Connection;

/**
 *
 * @author Carlos
 */
public class ProductoService {
    
    private ProductoDAO productoDAO;

    public ProductoService() {
        this.productoDAO = new ProductoDAO();
    }

    public Producto obtenerProducto(String nombre) {
        
        Producto registro = null;
        
        try(Connection connection = conexionBD.getConnection()){
            registro = productoDAO.obtenerProductoPorNombre(connection, nombre);
        } catch (Exception e){
            System.out.println("Error al buscar producto: " + e.getMessage());
        }
        
        return registro;
    }
    
}
