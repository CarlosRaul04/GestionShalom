/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.shalomgestion;

import com.View.shalomgestion.IniciarSesion;
import com.View.shalomgestion.MenuView;
import com.utils.shalomgestion.conexionBD;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.SwingUtilities;
/**
 *
 * @author Carlos
 */
public class ShalomGestion {

    public static void main(String[] args) {
       
        SwingUtilities.invokeLater(() -> {
        
            //Creamos la instancia del menu
            IniciarSesion menu = new IniciarSesion();
            
            menu.setVisible(true);
            menu.setSize(400, 320);
            menu.setLocationRelativeTo(null);
    });
        
        
    }
}
