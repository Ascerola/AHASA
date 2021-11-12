/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AveriaDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import modelo.Averia;
import modelo.Institucion;
import vista.frmReporteAverias;

/**
 *
 * @author coke zero
 */
public class ControllerAveria implements ActionListener {
    
    Averia averia = new Averia();
    AveriaDAO averiadao = new AveriaDAO();
    frmReporteAverias vistaAverias = new frmReporteAverias();
    Institucion institucion = new Institucion();
    
    public ControllerAveria(frmReporteAverias frm) {
        vistaAverias = frm;
        vistaAverias.btnGuardar.addActionListener(this);
        vistaAverias.btnCancelar.addActionListener(this);
        vistaAverias.btnEliminar.addActionListener(this);
        vistaAverias.btnActualizar.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {        
        if (e.getSource() == vistaAverias.btnGuardar) {
            if (vistaAverias.cbNivel.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(vistaAverias, "Debe seleccionar un nivel");
            } else if (vistaAverias.cbProvincia.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(vistaAverias, "Debe seleccionar una provincia");
            } else if (vistaAverias.txtDireccion.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaAverias, "Debe ingresar una direccion");
            } else if (vistaAverias.txtImagen.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaAverias, "Debe ingresar una direccion para la imagen");
            } else if (vistaAverias.txtDescripcion.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaAverias, "Debe ingresar una descripcion");
            } else if (vistaAverias.txtFechaIngreso.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaAverias, "Debe ingresar una fecha");
            } else if (vistaAverias.cbEstado.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(vistaAverias, "Debe seleccionar un estado");
            } else {
                try {
                    agregarAveria();
                } catch (ParseException ex) {
                    Logger.getLogger(ControllerAveria.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
         if (e.getSource() == vistaAverias.btnActualizar) {
            if (vistaAverias.cbNivel.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(vistaAverias, "Debe seleccionar un nivel");
            } else if (vistaAverias.cbProvincia.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(vistaAverias, "Debe seleccionar una provincia");
            } else if (vistaAverias.txtDireccion.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaAverias, "Debe ingresar una direccion");
            } else if (vistaAverias.txtImagen.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaAverias, "Debe ingresar una direccion para la imagen");
            } else if (vistaAverias.txtDescripcion.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaAverias, "Debe ingresar una descripcion");
            } else if (vistaAverias.txtFechaIngreso.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaAverias, "Debe ingresar una fecha");
            } else if (vistaAverias.cbEstado.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(vistaAverias, "Debe seleccionar un estado");
            } else {
                try {
                    actualizarAveria();
                } catch (ParseException ex) {
                    Logger.getLogger(ControllerAveria.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (e.getSource() == vistaAverias.btnCancelar) {
            limpiarCampos();
        }
        if (e.getSource() == vistaAverias.btnEliminar) {
            eliminarAveria();
        }
    }
    
    public void agregarAveria() throws ParseException {
        int idInstituciones = Integer.parseInt(vistaAverias.txtInstitucion.getText());
        int nivel = Integer.parseInt(vistaAverias.cbNivel.getSelectedItem().toString());
        String provincia = vistaAverias.cbProvincia.getSelectedItem().toString();
        String canton = vistaAverias.cbCanton.getSelectedItem().toString();
        String distrito = vistaAverias.cbDistrito.getSelectedItem().toString();
        String direccion = vistaAverias.txtDireccion.getText();
        String imagen = vistaAverias.txtImagen.getText();
        String descripcion = vistaAverias.txtDescripcion.getText();
        String fechaIngreso = vistaAverias.txtFechaIngreso.getText();
        String estado = vistaAverias.cbEstado.getSelectedItem().toString();        
        institucion.setIdInstitucion(idInstituciones);
        
        averia.setNivel(nivel);
        averia.setProvincia(provincia);
        averia.setCanton(canton);
        averia.setDistrito(distrito);
        averia.setDireccion(direccion);
        averia.setImagen(imagen);
        averia.setDescripcion(descripcion);
        averia.setfechaIngreso(fechaIngreso);
        averia.setEstado(estado);
        averia.setInstitucion(institucion);
        
        int r = averiadao.agregarAveria(averia);
        if (r == 1) {
            JOptionPane.showMessageDialog(vistaAverias, "Averia registrada con exito");
            filtrarTabla(vistaAverias.tblAverias, "");
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(vistaAverias, "Error al registrar la averia");
        }
    }
    public void actualizarAveria() throws ParseException {
        int idInstituciones = Integer.parseInt(vistaAverias.txtInstitucion.getText());
        int nivel = Integer.parseInt(vistaAverias.cbNivel.getSelectedItem().toString());
        String provincia = vistaAverias.cbProvincia.getSelectedItem().toString();
        String canton = vistaAverias.cbCanton.getSelectedItem().toString();
        String distrito = vistaAverias.cbDistrito.getSelectedItem().toString();
        String direccion = vistaAverias.txtDireccion.getText();
        String imagen = vistaAverias.txtImagen.getText();
        String descripcion = vistaAverias.txtDescripcion.getText();
        String fechaIngreso = vistaAverias.txtFechaIngreso.getText();
        String estado = vistaAverias.cbEstado.getSelectedItem().toString();
        institucion.setIdInstitucion(idInstituciones);
        boolean valida = false;
        
        int fila = vistaAverias.tblAverias.getSelectedRow();
        int id = Integer.parseInt(vistaAverias.tblAverias.getValueAt(fila, 0).toString());
        
        
        averia.setIdAveria(id);
        averia.setNivel(nivel);
        averia.setProvincia(provincia);
        averia.setCanton(canton);
        averia.setDistrito(distrito);
        averia.setDireccion(direccion);
        averia.setImagen(imagen);
        averia.setDescripcion(descripcion);
        averia.setfechaIngreso(fechaIngreso);
        averia.setEstado(estado);
        averia.setInstitucion(institucion);
        averia.setValida(valida);
        int r = averiadao.actualizarAveria(averia);
        if (r == 1) {
            JOptionPane.showMessageDialog(vistaAverias, "averia modificada con exito");
            filtrarTabla(vistaAverias.tblAverias, "");
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(vistaAverias, "Error, averia no modificada");
        }
    }
    public void limpiarCampos() {
        vistaAverias.cbNivel.setSelectedIndex(0);
        vistaAverias.txtDireccion.setText("");
        vistaAverias.txtImagen.setText("");
        vistaAverias.txtDescripcion.setText("");
        vistaAverias.txtFechaIngreso.setText("");
        vistaAverias.cbEstado.setSelectedIndex(0);
        vistaAverias.txtInstitucion.setText("");
    }
     public void eliminarAveria() {
        int fila = vistaAverias.tblAverias.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vistaAverias, "Debe seleccionar un registro en la tabla");
        } else {
            int idAveria = Integer.parseInt(vistaAverias.tblAverias.getValueAt(fila, 0).toString());
            int r = averiadao.eliminarAveria(idAveria);
            if (r == 1) {
                JOptionPane.showMessageDialog(vistaAverias, "Averia eliminada con exito");
                filtrarTabla(vistaAverias.tblAverias, "");
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(vistaAverias, "Cita no fue eliminada");
            }
        }
    }

    public void filtrarTabla(JTable table, String filtro) {
        averiadao.filtrarTabla(table, filtro);
    }
    
    public void iniciar() {
        filtrarTabla(vistaAverias.tblAverias, "");
        limpiarCampos();
    }
    
}
