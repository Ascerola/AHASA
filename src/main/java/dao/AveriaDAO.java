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
    
    //Metodos para frmReporteAverias
    public void filtrarTablaPorFiltro(JTable table, String filtrotxt, String filtrocb) {
        String[] titulos = {"ID", "NIVEL", "PROVINCIA", "CANTON", "DISTRITO", "DIRECCION", "IMAGEN", "ID INSTITUCION", "DESCRIPCION", "FECHA INGRESO", "ESTADO", "VALIDA"};
        String[] registros = new String[12];
        String sql = "SELECT * FROM averias WHERE " + filtrocb + " LIKE '%" + filtrotxt + "%' AND valida =0";
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
        String sql = "SELECT * FROM averias WHERE idAverias LIKE '%" + filtro + "%' AND valida =0";
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
    //Metodos para frmSeguimientoAverias
    public void filtrarTablaSeguimiento(JTable table, String filtro) {
        String[] titulos = {"ID", "NIVEL", "PROVINCIA", "CANTON", "DISTRITO", "DIRECCION", "IMAGEN", "ID INSTITUCION", "DESCRIPCION", "FECHA INGRESO", "ESTADO", "SOLUCION", "HORAS", "NUM EMPLEADOS", "COSTO", "RESPONSABLE", "VALIDA", "FECHA ARREGLO"};
        String[] registros = new String[18];
        String sql = "SELECT * FROM averias WHERE idAverias LIKE '%" + filtro + "%' AND valida =1";
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
                registros[11] = rs.getString("descSolucion");
                registros[12] = rs.getString("tiempoInvertido");
                registros[13] = rs.getString("empleadosInvolucrados");
                registros[14] = rs.getString("costo");
                registros[15] = rs.getString("responsable");
                registros[16] = rs.getString("valida");
                registros[17] = rs.getString("fechaArreglo");
                model.addRow(registros);
            }
            table.setModel(model);
        } catch (SQLException e) {  
            System.out.println("Error al cargar datos" + e.getMessage());
        }
    }
    public int actualizarSeguimientoAveria(Averia averia) {
        int r = 0;
        String sql = "UPDATE averias SET imagen=?, estado=?, descSolucion=?, tiempoInvertido=?, empleadosInvolucrados=?, costo=?, responsable=?, fechaArreglo=? WHERE idAverias=?";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);  
            ps.setString(1, averia.getImagen());
            ps.setString(2, averia.getEstado());
            ps.setString(3, averia.getDescSolucion());
            ps.setInt(4, averia.getTiempoInvertido());
            ps.setInt(5, averia.getEmpleadosInvolucrados());
            ps.setDouble(6, averia.getCosto());
            ps.setString(7, averia.getResponsable());
            ps.setString(8, averia.getFechaArreglo());
            ps.setInt(9, averia.getIdAveria());
            r = ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al cargar datos" + e.getMessage());
        }
        return r;
    }    
    public int pausarSeguimientoAveria(Averia averia) {
        int r = 0;
        String sql = "UPDATE averias SET estado=? WHERE idAverias=?";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);  
            ps.setString(1, averia.getEstado());
            ps.setInt(2, averia.getIdAveria());
            r = ps.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Error al cargar datos" + e.getMessage());
        }
        return r;
    }
    
}
