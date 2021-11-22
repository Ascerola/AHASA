/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author coke zero
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import modelo.Averia;
import vista.frmInversionConceptoAverias;
import dao.InversionConceptoAveriaDAO;

public class ControllerInversionConceptoAveria implements ActionListener {
    Averia averia = new Averia();
    InversionConceptoAveriaDAO inversionDAO = new InversionConceptoAveriaDAO();
    frmInversionConceptoAverias vistaInversion = new frmInversionConceptoAverias();

    public ControllerInversionConceptoAveria(frmInversionConceptoAverias frm) {
        vistaInversion = frm;
        vistaInversion.btnBuscar.addActionListener(this);
        //vistaInversion.btnResultados.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaInversion.btnBuscar) {
            if (vistaInversion.cbFiltro.getSelectedItem().equals("Periodo de tiempo")) {
                filtrarTablaPorTiempo(vistaInversion.tblAverias, vistaInversion.txtBuscar.getText());
                operaciones();
            }
            else if (vistaInversion.cbFiltro.getSelectedItem().equals("ID institución")) {
                filtrarTablaPorInstitución(vistaInversion.tblAverias, vistaInversion.txtBuscar.getText());
                operaciones();
            }
            else if (vistaInversion.cbFiltro.getSelectedItem().equals("provincia")) {
                filtrarTablaPorProvincia(vistaInversion.tblAverias, vistaInversion.txtBuscar.getText());
                operaciones();
            }
            else if (vistaInversion.cbFiltro.getSelectedItem().equals("cantón")) {
                filtrarTablaPorCanton(vistaInversion.tblAverias, vistaInversion.txtBuscar.getText());
                operaciones();
            }
        }
    }

    public void filtrarTablaPorTiempo(JTable table, String filtro) {
        inversionDAO.filtrarTablaPorTiempo(table, filtro);
    }

    public void filtrarTablaPorInstitución(JTable table, String filtro) {
        inversionDAO.filtrarTablaPorInstitucion(table, filtro);
    }

    public void filtrarTablaPorProvincia(JTable table, String filtro) {
        inversionDAO.filtrarTablaPorProvincia(table, filtro);
    }

    public void filtrarTablaPorCanton(JTable table, String filtro) {
        inversionDAO.filtrarTablaPorCanton(table, filtro);
    }
    
    public void iniciar(){
        inversionDAO.filtrarTablaPorTiempo(vistaInversion.tblAverias, "");
        operaciones();
    }
    
    public void operaciones(){
        sumaTiempo();
        sumaCosto();
        promedioEmpleados();
    }
    
    public void sumaTiempo(){
        int contar = vistaInversion.tblAverias.getRowCount();
        int suma = 0;
        for (int i = 0; i <contar; i++) {
            
            suma = suma + Integer.parseInt(vistaInversion.tblAverias.getValueAt(i, 2).toString());
        }
        vistaInversion.txtTiempo.setText(Integer.toString(suma));
    }
    
    public void sumaCosto(){
        int contar = vistaInversion.tblAverias.getRowCount();
        double suma = 0;
        for (int i = 0; i <contar; i++) {
            
            suma = suma + Double.parseDouble(vistaInversion.tblAverias.getValueAt(i, 1).toString());
        }
        vistaInversion.txtCosto.setText(Double.toString(suma));
    }
    
    public void promedioEmpleados(){
        int contar = vistaInversion.tblAverias.getRowCount();
        int suma = 0;
        for (int i = 0; i <contar; i++) {
            
            suma = suma + Integer.parseInt(vistaInversion.tblAverias.getValueAt(i, 3).toString());
        }
        int promedio = suma / contar;
        vistaInversion.txtPersonas.setText(Integer.toString(promedio));
    }
}
