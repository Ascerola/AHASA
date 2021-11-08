/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Conexion;
import modelo.Usuario;

/**
 *
 * @author Ana
 */
public class UsuarioDAO {
    
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion conectar = new Conexion();
    
        public boolean login(Usuario user) {
        String sql = "SELECT idUsuarios, nombreUsuario, password, tipo FROM usuarios WHERE nombreUsuario=?";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getNombreUsuario());           
            rs = ps.executeQuery(); 
            if (rs.next()){               
                if (user.getPassword().equals(rs.getString("password")) && user.getTipo().equals(rs.getString("tipo"))) {
                    user.setIdUsuario(rs.getInt("idUsuarios"));
                    user.setNombreUsuario(rs.getString("nombreUsuario"));
                    user.setTipo(rs.getString("tipo"));
                    return true;
                }
            }
            return false;
        } catch (SQLException e) {
            return false;
        }
    }
}
