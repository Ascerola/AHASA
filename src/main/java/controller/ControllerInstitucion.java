/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.InstitucionDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import modelo.Institucion;
import vista.frmInstitucion;

/**
 *
 * @author coke zero
 */
public class ControllerInstitucion implements ActionListener {

    Institucion institucion = new Institucion();
    InstitucionDAO instituciondao = new InstitucionDAO();
    frmInstitucion vistaInstitucion = new frmInstitucion();

    public ControllerInstitucion(frmInstitucion frm) {
        vistaInstitucion = frm;
        vistaInstitucion.btnGuardar.addActionListener(this);
        vistaInstitucion.btnActualizar.addActionListener(this);
        vistaInstitucion.btnCancelar.addActionListener(this);
        vistaInstitucion.btnEliminar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaInstitucion.btnGuardar) {
            if (vistaInstitucion.txtPassword.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaInstitucion, "Debe ingresar una contrasena");
            } else if (vistaInstitucion.txtCorreo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaInstitucion, "Debe seleccionar un correo");
            } else if (vistaInstitucion.txtNombre.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaInstitucion, "Debe ingresar un nombre");
            } else if (vistaInstitucion.txtRazon.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaInstitucion, "Debe ingresar una razon social");
            } else {
                try {
                    agregarInstitucion();
                } catch (ParseException ex) {
                    Logger.getLogger(ControllerInstitucion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (e.getSource() == vistaInstitucion.btnActualizar) {
            if (vistaInstitucion.txtPassword.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaInstitucion, "Debe ingresar una contrasena");
            } else if (vistaInstitucion.txtCorreo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaInstitucion, "Debe ingresar un correo");
            } else if (vistaInstitucion.txtNombre.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaInstitucion, "Debe ingresar un nombre");
            } else if (vistaInstitucion.txtRazon.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaInstitucion, "Debe ingresar una razon social");
            } else {
                try {
                    actualizarInstitucion();
                } catch (ParseException ex) {
                    Logger.getLogger(ControllerInstitucion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (e.getSource() == vistaInstitucion.btnEliminar) {
            eliminarInstituciones();
        }
        if (e.getSource() == vistaInstitucion.btnCancelar) {
            limpiarCampos();
        }
    }

    public void agregarInstitucion() throws ParseException {

        String password = vistaInstitucion.txtPassword.getText();
        String correo = vistaInstitucion.txtCorreo.getText();
        String nombre = vistaInstitucion.txtNombre.getText();
        String razon = vistaInstitucion.txtRazon.getText();
        boolean reporteador = vistaInstitucion.checkSi.isSelected();

        institucion.setPassword(password);
        institucion.setCorreo(correo);
        institucion.setNombre(nombre);
        institucion.setRazonSocial(razon);
        institucion.setEsReporteador(reporteador);

        int r = instituciondao.agregarInstitucion(institucion);
        if (r == 1) {
            JOptionPane.showMessageDialog(vistaInstitucion, "Institucion registrada con exito");
            filtrarTabla(vistaInstitucion.tblInstituciones, "");
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(vistaInstitucion, "Error al registrar la Institucion");
        }
    }

    public void eliminarInstituciones() {
        int fila = vistaInstitucion.tblInstituciones.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vistaInstitucion, "Debe seleccionar un registro en la tabla");
        } else {
            int idInstituciones = Integer.parseInt(vistaInstitucion.tblInstituciones.getValueAt(fila, 0).toString());
            int r = instituciondao.eliminarInstituciones(idInstituciones);
            if (r == 1) {
                JOptionPane.showMessageDialog(vistaInstitucion, "Institucion eliminada con exito");
                filtrarTabla(vistaInstitucion.tblInstituciones, "");
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(vistaInstitucion, "Institucion no fue eliminada");
            }
        }
    }
    public void actualizarInstitucion() throws ParseException {
        String password = vistaInstitucion.txtPassword.getText();
        String correo = vistaInstitucion.txtCorreo.getText();
        String nombre = vistaInstitucion.txtNombre.getText();
        String razon = vistaInstitucion.txtRazon.getText();
        boolean reporteador = vistaInstitucion.checkSi.isSelected();

        int fila = vistaInstitucion.tblInstituciones.getSelectedRow();
        int id = Integer.parseInt(vistaInstitucion.tblInstituciones.getValueAt(fila, 0).toString());
        
        institucion.setIdInstitucion(id);
        institucion.setPassword(password);
        institucion.setCorreo(correo);
        institucion.setNombre(nombre);
        institucion.setRazonSocial(razon);
        institucion.setEsReporteador(reporteador);
        
        int r = instituciondao.actualizarInstitucion(institucion);
        if (r == 1) {
            JOptionPane.showMessageDialog(vistaInstitucion, "Institucion modificada con exito");
            filtrarTabla(vistaInstitucion.tblInstituciones, "");
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(vistaInstitucion, "Error, Institucion no modificada");
        }
    }

    public void filtrarTabla(JTable table, String filtro) {
        instituciondao.filtrarTablaPorFiltro(table, filtro);
    }

    public void limpiarCampos() {
        vistaInstitucion.txtPassword.setText("");
        vistaInstitucion.txtCorreo.setText("");
        vistaInstitucion.txtNombre.setText("");
        vistaInstitucion.txtRazon.setText("");
        vistaInstitucion.checkSi.setSelected(false);
    }

    public void iniciar() {
        filtrarTabla(vistaInstitucion.tblInstituciones, "");
        limpiarCampos();
    }
}
