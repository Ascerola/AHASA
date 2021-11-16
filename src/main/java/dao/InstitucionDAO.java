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
import modelo.Institucion;

/**
 *
 * @author coke zero
 */
public class InstitucionDAO {

    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion conectar = new Conexion();

    public void filtrarTablaPorFiltro(JTable table, String filtrotxt) {
        String[] titulos = {"ID", "PASSWORD", "CORREO", "NOMBRE", "RAZON SOCIAL", "REPORTEADOR"};
        String[] registros = new String[6];
        String sql = "SELECT * FROM instituciones WHERE idInstituciones LIKE '%" + filtrotxt + "%'";
        DefaultTableModel model = new DefaultTableModel(null, titulos);
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                registros[0] = rs.getString("idInstituciones");
                registros[1] = rs.getString("password");
                registros[2] = rs.getString("correo");
                registros[3] = rs.getString("nombre");
                registros[4] = rs.getString("razonSocial");
                registros[5] = rs.getString("esReporteador");
                model.addRow(registros);
            }
            table.setModel(model);
        } catch (SQLException e) {
            System.out.println("Error al cargar datos" + e.getMessage());
        }
    }

    public int agregarInstitucion(Institucion institucion) {
        int r = 0;
        String sql = "INSERT INTO instituciones (password, correo, nombre, razonSocial, esReporteador) VALUES (?, ?, ?, ?, ?)";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, institucion.getPassword());
            ps.setString(2, institucion.getCorreo());
            ps.setString(3, institucion.getNombre());
            ps.setString(4, institucion.getRazonSocial());
            ps.setBoolean(5, institucion.isEsReporteador());
            r = ps.executeUpdate();
        } catch (SQLException e) {
        }
        return r;
    }

    public int actualizarInstitucion(Institucion institucion) {
        int r = 0;
        String sql = "UPDATE instituciones SET password=?, correo=?, nombre=?, razonSocial=?, esReporteador=? WHERE idInstituciones=?";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, institucion.getPassword());
            ps.setString(2, institucion.getCorreo());
            ps.setString(3, institucion.getNombre());
            ps.setString(4, institucion.getRazonSocial());
            ps.setBoolean(5, institucion.isEsReporteador());
            ps.setInt(6, institucion.getIdInstitucion());
            r = ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al cargar datos" + e.getMessage());
        }
        return r;
    }

    public int eliminarInstituciones(int id) {
        int r = 0;
        String sql = "DELETE FROM instituciones WHERE idInstituciones =" + id;
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            r = ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al eliminar la institucion" + e.getMessage());
        }
        return r;
    }
}
