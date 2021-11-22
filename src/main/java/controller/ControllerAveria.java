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
import vista.frmSeguimientoAverias;

/**
 *
 * @author coke zero
 */
public class ControllerAveria implements ActionListener {

    Averia averia = new Averia();
    AveriaDAO averiadao = new AveriaDAO();
    frmReporteAverias vistaAverias = new frmReporteAverias();
    Institucion institucion = new Institucion();
    frmSeguimientoAverias vistaAveriasSeguimiento = new frmSeguimientoAverias();

    public ControllerAveria(frmReporteAverias frm) {
        vistaAverias = frm;
        vistaAverias.btnGuardar.addActionListener(this);
        vistaAverias.btnCancelar.addActionListener(this);
        vistaAverias.btnEliminar.addActionListener(this);
        vistaAverias.btnActualizar.addActionListener(this);
        vistaAverias.btnFiltrar.addActionListener(this);
        vistaAverias.btnValidar.addActionListener(this);
    }

    public ControllerAveria(frmSeguimientoAverias frm1) {
        vistaAveriasSeguimiento = frm1;
        vistaAveriasSeguimiento.btnCancelar.addActionListener(this);
        vistaAveriasSeguimiento.btnFiltrar.addActionListener(this);
        vistaAveriasSeguimiento.btnFinalizada.addActionListener(this);
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
        if (e.getSource() == vistaAverias.btnValidar) {
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
                    actualizarValido();
                } catch (ParseException ex) {
                    Logger.getLogger(ControllerAveria.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (e.getSource() == vistaAverias.btnFiltrar) {
            filtrarTablaPorFiltro(vistaAverias.tblAverias, vistaAverias.txtFiltro.getText(), vistaAverias.cbFiltro.getSelectedItem().toString());
        }
        if (e.getSource() == vistaAveriasSeguimiento.btnFinalizada) {
            if (vistaAveriasSeguimiento.txtDesc.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaAveriasSeguimiento, "Debe ingresar una descripcion");
            } else if (vistaAveriasSeguimiento.txtHoras.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaAveriasSeguimiento, "Debe ingresar un numero de horas");
            } else if (vistaAveriasSeguimiento.txtEmpleados.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaAveriasSeguimiento, "Debe ingresar un numero de empleados");
            } else if (vistaAveriasSeguimiento.txtCosto.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaAveriasSeguimiento, "Debe ingresar un costo");
            } else if (vistaAveriasSeguimiento.txtResp.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaAveriasSeguimiento, "Debe ingresar un responsable");
            } else if (vistaAveriasSeguimiento.txtFoto.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaAveriasSeguimiento, "Debe seleccionar una direccion para la imagen");
            } else {
                try {
                    actualizarSeguimientoAveria();
                } catch (ParseException ex) {
                    Logger.getLogger(ControllerAveria.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (e.getSource() == vistaAveriasSeguimiento.btnCancelar) {
            try {
                pausarSeguimientoAveria();
            } catch (ParseException ex) {
                Logger.getLogger(ControllerAveria.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == vistaAveriasSeguimiento.btnFiltrar) {
            filtrarTablaSeguimiento(vistaAveriasSeguimiento.tblAverias, vistaAveriasSeguimiento.txtFiltroId.getText());
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
        boolean valida = false;
        
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

    public void actualizarValido() throws ParseException {
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
        boolean valida = true;

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
            JOptionPane.showMessageDialog(vistaAverias, "averia validada con exito");
            filtrarTabla(vistaAverias.tblAverias, "");
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(vistaAverias, "Error, averia no validada");
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

    public void filtrarTablaPorFiltro(JTable table, String filtrotxt, String filtrocb) {
        averiadao.filtrarTablaPorFiltro(table, filtrotxt, filtrocb);
    }

    public void iniciar() {
        filtrarTabla(vistaAverias.tblAverias, "");
        limpiarCampos();
    }

    //Metodos Seguimiento de averias
    public void filtrarTablaSeguimiento(JTable table, String filtrotxt) {
        averiadao.filtrarTablaSeguimiento(vistaAveriasSeguimiento.tblAverias, filtrotxt);
    }

    public void limpiarCamposSeguimiento() {
        vistaAveriasSeguimiento.txtDesc.setText("");
        vistaAveriasSeguimiento.txtHoras.setText("");
        vistaAveriasSeguimiento.txtEmpleados.setText("");
        vistaAveriasSeguimiento.txtCosto.setText("");
        vistaAveriasSeguimiento.txtResp.setText("");
        vistaAveriasSeguimiento.txtFoto.setText("");
        vistaAveriasSeguimiento.txtFechaArreglo.setText("");
    }

    public void iniciarSeguimientoAverias() {
        filtrarTablaSeguimiento(vistaAveriasSeguimiento.tblAverias, "");
        limpiarCampos();
    }

    public void actualizarSeguimientoAveria() throws ParseException {
        String estado = "Finalizada";
        String imagen = vistaAveriasSeguimiento.txtFoto.getText();
        String solucion = vistaAveriasSeguimiento.txtDesc.getText();
        int horas = Integer.parseInt(vistaAveriasSeguimiento.txtHoras.getText());
        int empleados = Integer.parseInt(vistaAveriasSeguimiento.txtEmpleados.getText());
        double costo = Double.parseDouble(vistaAveriasSeguimiento.txtCosto.getText());
        String responsable = vistaAveriasSeguimiento.txtResp.getText();
        String fechaArreglo = vistaAveriasSeguimiento.txtFechaArreglo.getText();

        int fila = vistaAveriasSeguimiento.tblAverias.getSelectedRow();
        int id = Integer.parseInt(vistaAveriasSeguimiento.tblAverias.getValueAt(fila, 0).toString());

        averia.setIdAveria(id);
        averia.setEstado(estado);
        averia.setImagen(imagen);
        averia.setDescSolucion(solucion);
        averia.setTiempoInvertido(horas);
        averia.setEmpleadosInvolucrados(empleados);
        averia.setCosto(costo);
        averia.setResponsable(responsable);
        averia.setFechaArreglo(fechaArreglo);

        int r = averiadao.actualizarSeguimientoAveria(averia);
        if (r == 1) {
            JOptionPane.showMessageDialog(vistaAveriasSeguimiento, "averia modificada con exito");
            filtrarTablaSeguimiento(vistaAveriasSeguimiento.tblAverias, "");
            limpiarCamposSeguimiento();
        } else {
            JOptionPane.showMessageDialog(vistaAveriasSeguimiento, "Error, averia no modificada");
        }
    }
    public void pausarSeguimientoAveria() throws ParseException {
        String estado = "Pausa";
        int fila = vistaAveriasSeguimiento.tblAverias.getSelectedRow();
        int id = Integer.parseInt(vistaAveriasSeguimiento.tblAverias.getValueAt(fila, 0).toString());
        averia.setIdAveria(id);
        averia.setEstado(estado);

        int r = averiadao.pausarSeguimientoAveria(averia);
        if (r == 1) {
            JOptionPane.showMessageDialog(vistaAveriasSeguimiento, "averia pausada con exito");
            filtrarTablaSeguimiento(vistaAveriasSeguimiento.tblAverias, "");
            limpiarCamposSeguimiento();
        } else {
            JOptionPane.showMessageDialog(vistaAveriasSeguimiento, "Error, averia no pausada");
        }
    }
}
