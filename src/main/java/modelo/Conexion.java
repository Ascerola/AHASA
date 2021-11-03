/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
import java.sql.Statement;



/**
 *
 * @author coke zero
 */
public class Conexion {
    
    Connection ccn = null;
    Statement st = null;
    
     public Conexion() {
        String url = "jdbc:mysql://localhost:3306/ahasadb";
        String user = "root";
        String pass = "Villalobos12435";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            ccn = DriverManager.getConnection(url,user,pass);
            st = ccn.createStatement(); 
            
            System.out.println("Conexion funcionando" + url);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    public Connection getConnection() {
        return ccn;
   }
    
   public void desconexion() {
        try {
            ccn.close();
            System.exit(0);
        } catch (SQLException e) {

        }
   }
   
}
