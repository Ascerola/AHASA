/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import dao.CiudadanoDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import modelo.Ciudadano;
import vista.frmCiudadanos;
/**
 *
 * @author coke zero
 */
public class ControllerCiudadano implements ActionListener {
    
    Ciudadano ciudadano = new Ciudadano();
    CiudadanoDAO ciudadanodao = new CiudadanoDAO();
    frmCiudadanos vistaCiudadano = new frmCiudadanos();

    public ControllerCiudadano(frmCiudadanos frm) {
        vistaCiudadano = frm;
        vistaCiudadano.btnGuardar.addActionListener(this);
        vistaCiudadano.btnCancelar.addActionListener(this);
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaCiudadano.btnGuardar) {
            if (vistaCiudadano.txtCedula.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaCiudadano, "Debe ingresar un Numero de Identificacion");
            } else if (vistaCiudadano.JPass.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaCiudadano, "Debe ingresar una contrasena");
            } else if (vistaCiudadano.txtCorreo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaCiudadano, "Debe seleccionar un correo");
            } else if (vistaCiudadano.txtNombre.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaCiudadano, "Debe ingresar un nombre");
            } else if (vistaCiudadano.txtApe1.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaCiudadano, "Debe ingresar el Primer Apellido");
            } else if (vistaCiudadano.txtApe2.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaCiudadano, "Debe ingresar el Segundo Apellido");
            } else {
                try {
                    agregarInstitucion();
                } catch (ParseException ex) {
                    Logger.getLogger(ControllerCiudadano.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        if (e.getSource() == vistaCiudadano.btnCancelar) {
            limpiarCampos();
        }
    }

    public void agregarInstitucion() throws ParseException {

        int cedula = Integer.parseInt(vistaCiudadano.txtCedula.getText());
        String password = vistaCiudadano.JPass.getText();
        String correo = vistaCiudadano.txtCorreo.getText();
        String nombre = vistaCiudadano.txtNombre.getText();
        String ape1 = vistaCiudadano.txtApe1.getText();
        String ape2 = vistaCiudadano.txtApe2.getText();
        
        ciudadano.setCedula(cedula);
        ciudadano.setPassword(password);
        ciudadano.setCorreo(correo);
        ciudadano.setNombre(nombre);
        ciudadano.setApe1(ape1);
        ciudadano.setApe2(ape2);

        int r = ciudadanodao.agregarCiudadano(ciudadano);
        if (r == 1) {
            JOptionPane.showMessageDialog(vistaCiudadano, "Ciudadano registrado con exito");
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(vistaCiudadano, "Error al registrar el Ciudadano");
        }
    }

    public void limpiarCampos() {
        vistaCiudadano.txtCedula.setText("");
        vistaCiudadano.JPass.setText("");
        vistaCiudadano.txtCorreo.setText("");
        vistaCiudadano.txtNombre.setText("");
        vistaCiudadano.txtApe1.setText("");
        vistaCiudadano.txtApe2.setText("");
    }

    public void iniciar() {
        limpiarCampos();
    }
}
