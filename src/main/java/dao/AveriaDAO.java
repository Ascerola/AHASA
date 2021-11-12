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
import modelo.Averia;
import modelo.Conexion;

/**
 *
 * @author coke zero
 */
public class AveriaDAO {
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion conectar = new Conexion();
    
    public void filtrarTablaPorFiltro(JTable table, String filtrotxt, String filtrocb) {
        String[] titulos = {"ID", "NIVEL", "PROVINCIA", "CANTON", "DISTRITO", "DIRECCION", "IMAGEN", "ID INSTITUCION", "DESCRIPCION", "FECHA INGRESO", "ESTADO", "VALIDA"};
        String[] registros = new String[12];
        String sql = "SELECT * FROM averias WHERE "+ filtrocb +" LIKE '%" + filtrotxt + "%'";
        DefaultTableModel model = new DefaultTableModel(null, titulos);       
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                registros[0] = rs.getString("idAverias");
                registros[1] = rs.getString("nivel");
                registros[2] = rs.getString("provincia");
                registros[3] = rs.getString("canton");
                registros[4] = rs.getString("distrito");
                registros[5] = rs.getString("direccion");
                registros[6] = rs.getString("imagen");
                registros[7] = rs.getString("idInstituciones");
                registros[8] = rs.getString("descripcion");
                registros[9] = rs.getString("fechaIngreso");
                registros[10] = rs.getString("estado");
                registros[11] = rs.getString("valida");                
                model.addRow(registros);
            }
            table.setModel(model);
        } catch (SQLException e) {
            System.out.println("Error al cargar datos" + e.getMessage());
        }
    }
    public void filtrarTabla(JTable table, String filtro) {
        String[] titulos = {"ID", "NIVEL", "PROVINCIA", "CANTON", "DISTRITO", "DIRECCION", "IMAGEN", "ID INSTITUCION", "DESCRIPCION", "FECHA INGRESO", "ESTADO", "VALIDA"};
        String[] registros = new String[12];
        String sql = "SELECT * FROM averias WHERE idAverias LIKE '%" + filtro + "%'";
        DefaultTableModel model = new DefaultTableModel(null, titulos);       
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                registros[0] = rs.getString("idAverias");
                registros[1] = rs.getString("nivel");
                registros[2] = rs.getString("provincia");
                registros[3] = rs.getString("canton");
                registros[4] = rs.getString("distrito");
                registros[5] = rs.getString("direccion");
                registros[6] = rs.getString("imagen");
                registros[7] = rs.getString("idInstituciones");
                registros[8] = rs.getString("descripcion");
                registros[9] = rs.getString("fechaIngreso");
                registros[10] = rs.getString("estado");
                registros[11] = rs.getString("valida");                
                model.addRow(registros);
            }
            table.setModel(model);
        } catch (SQLException e) {
            System.out.println("Error al cargar datos" + e.getMessage());
        }
    }
    public int agregarAveria(Averia averia) {
        int r = 0;
        String sql = "INSERT INTO averias (nivel, provincia, canton, distrito, direccion, imagen, idInstituciones, descripcion, fechaIngreso, estado, valida) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, averia.getNivel());
            ps.setString(2, averia.getProvincia());
            ps.setString(3, averia.getCanton());
            ps.setString(4, averia.getDistrito());
            ps.setString(5, averia.getDireccion());
            ps.setString(6, averia.getImagen());
            ps.setInt(7, averia.getInstitucion().getIdInstitucion());
            ps.setString(8, averia.getDescripcion());
            ps.setString(9, averia.getfechaIngreso());
            ps.setString(10, averia.getEstado());
            ps.setBoolean(11, averia.getValida());
            r = ps.executeUpdate();
        } catch (SQLException e) {
        }
        return r;
    }
    public int eliminarAveria(int id) {
        int r = 0;
        String sql = "DELETE FROM averias WHERE idAverias =" + id;
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            r = ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al eliminar la averia" + e.getMessage());
        }
        return r;

    }
    public int actualizarAveria(Averia averia) {
        int r = 0;
        String sql = "UPDATE averias SET nivel=?, provincia=?, canton=?, distrito=?, direccion=?, imagen=?, idInstituciones=?, descripcion=?, fechaIngreso=?, estado=?, valida=? WHERE idAverias=?";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, averia.getNivel());
            ps.setString(2, averia.getProvincia());
            ps.setString(3, averia.getCanton());
            ps.setString(4, averia.getDistrito());
            ps.setString(5, averia.getDireccion());
            ps.setString(6, averia.getImagen());
            ps.setInt(7, averia.getInstitucion().getIdInstitucion());
            ps.setString(8, averia.getDescripcion());
            ps.setString(9, averia.getfechaIngreso());
            ps.setString(10, averia.getEstado());
            ps.setBoolean(11, averia.getValida());
             ps.setInt(12, averia.getIdAveria());
            r = ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al cargar datos" + e.getMessage());
        }
        return r;
    }
}
