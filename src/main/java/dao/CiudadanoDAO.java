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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Conexion;
import modelo.Ciudadano;
/**
 *
 * @author coke zero
 */
public class CiudadanoDAO {
    
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion conectar = new Conexion();
    
    public int agregarCiudadano(Ciudadano ciudadano) {
        int r = 0;
        String sql = "INSERT INTO ciudadanos (cedula, password, correo, nombre, apellido1, apellido2) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, ciudadano.getCedula());
            ps.setString(2, ciudadano.getPassword());
            ps.setString(3, ciudadano.getCorreo());
            ps.setString(4, ciudadano.getNombre());
            ps.setString(5, ciudadano.getApe1());
            ps.setString(6, ciudadano.getApe2());
            r = ps.executeUpdate();
        } catch (SQLException e) {
        }
        return r;
    }

    public int actualizarCiudadano(Ciudadano ciudadano) {
        int r = 0;
        String sql = "UPDATE instituciones SET cedula=?, password=?, correo=?, nombre=?, apellido1=?, apellido2=? WHERE idCiudadanos=?";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, ciudadano.getCedula());
            ps.setString(2, ciudadano.getPassword());
            ps.setString(3, ciudadano.getCorreo());
            ps.setString(4, ciudadano.getNombre());
            ps.setString(5, ciudadano.getApe1());
            ps.setString(6, ciudadano.getApe2());
            r = ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al cargar datos" + e.getMessage());
        }
        return r;
    }

    public int eliminarCiudadano(int id) {
        int r = 0;
        String sql = "DELETE FROM ciudadanos WHERE idCiudadanos =" + id;
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            r = ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al eliminar el Ciudadano" + e.getMessage());
        }
        return r;
    }
}
