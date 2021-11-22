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
import vista.frmInversionConceptoAverias;
import modelo.Conexion;
/**
 *
 * @author coke zero
 */
public class InversionConceptoAveriaDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion conectar = new Conexion();
    frmInversionConceptoAverias vistaInversion = new frmInversionConceptoAverias();
    
    public void filtrarTablaPorTiempo(JTable table, String filtro) {
        String[] titulos = {"NÚMERO DE AVERÍA", "COSTO DE AVERÍA", "TIEMPO INVERTIDO", "CANTIDAD DE COLABORADORES", "FECHA DE ARREGLO", "NIVEL DE INCIDENCIA", "ID INSTITUCIÓN"};
        String[] registros = new String[titulos.length];
        String sql = "SELECT * FROM averias WHERE tiempoInvertido LIKE '%" + filtro + "%' AND estado = 'Finalizada'";
        DefaultTableModel model = new DefaultTableModel(null, titulos);
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                registros[0] = rs.getString("idAverias");
                registros[1] = rs.getString("costo");
                registros[2] = rs.getString("tiempoInvertido");
                registros[3] = rs.getString("empleadosInvolucrados");
                registros[4] = rs.getString("fechaArreglo");
                registros[5] = rs.getString("nivel");
                registros[6] = rs.getString("idInstituciones");
                model.addRow(registros);
            }
            table.setModel(model);
        } catch (SQLException e) {
            System.out.println("Error al cargar los datos" + e.getMessage());
        }
    }
    public void filtrarTablaPorInstitucion(JTable table, String filtro) {
        String[] titulos = {"NÚMERO DE AVERÍA", "COSTO DE AVERÍA", "TIEMPO INVERTIDO", "CANTIDAD DE COLABORADORES", "FECHA DE ARREGLO", "NIVEL DE INCIDENCIA", "ID INSTITUCIÓN"};
        String[] registros = new String[titulos.length];
        String sql = "SELECT * FROM averias WHERE idInstituciones LIKE '%" + filtro + "%' AND estado = 'Finalizada'";
        DefaultTableModel model = new DefaultTableModel(null, titulos);
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                registros[0] = rs.getString("idAverias");
                registros[1] = rs.getString("costo");
                registros[2] = rs.getString("tiempoInvertido");
                registros[3] = rs.getString("empleadosInvolucrados");
                registros[4] = rs.getString("fechaArreglo");
                registros[5] = rs.getString("nivel");
                registros[6] = rs.getString("idInstituciones");
                model.addRow(registros);
            }
            table.setModel(model);
        } catch (SQLException e) {
            System.out.println("Error al cargar los datos" + e.getMessage());
        }
    }
    public void filtrarTablaPorProvincia(JTable table, String filtro) {
        String[] titulos = {"NÚMERO DE AVERÍA", "COSTO DE AVERÍA", "TIEMPO INVERTIDO", "CANTIDAD DE COLABORADORES", "FECHA DE ARREGLO", "NIVEL DE INCIDENCIA", "ID INSTITUCIÓN"};
        String[] registros = new String[titulos.length];
        String sql = "SELECT * FROM averias WHERE provincia LIKE '%" + filtro + "%' AND estado = 'Finalizada'";
        DefaultTableModel model = new DefaultTableModel(null, titulos);
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                registros[0] = rs.getString("idAverias");
                registros[1] = rs.getString("costo");
                registros[2] = rs.getString("tiempoInvertido");
                registros[3] = rs.getString("empleadosInvolucrados");
                registros[4] = rs.getString("fechaArreglo");
                registros[5] = rs.getString("nivel");
                registros[6] = rs.getString("idInstituciones");
                model.addRow(registros);
            }
            table.setModel(model);
        } catch (SQLException e) {
            System.out.println("Error al cargar los datos" + e.getMessage());
        }
    }
    
    public void filtrarTablaPorCanton(JTable table, String filtro) {
        String[] titulos = {"NÚMERO DE AVERÍA", "COSTO DE AVERÍA", "TIEMPO INVERTIDO", "CANTIDAD DE COLABORADORES", "FECHA DE ARREGLO", "NIVEL DE INCIDENCIA", "ID INSTITUCIÓN"};
        String[] registros = new String[titulos.length];
        String sql = "SELECT * FROM averias WHERE canton LIKE '%" + filtro + "%' AND estado = 'Finalizada'";
        DefaultTableModel model = new DefaultTableModel(null, titulos);
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                registros[0] = rs.getString("idAverias");
                registros[1] = rs.getString("costo");
                registros[2] = rs.getString("tiempoInvertido");
                registros[3] = rs.getString("empleadosInvolucrados");
                registros[4] = rs.getString("fechaArreglo");
                registros[5] = rs.getString("nivel");
                registros[6] = rs.getString("idInstituciones");
                model.addRow(registros);
            }
            table.setModel(model);
        } catch (SQLException e) {
            System.out.println("Error al cargar los datos" + e.getMessage());
        }
    }
}
