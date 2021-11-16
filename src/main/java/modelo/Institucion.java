/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author coke zero
 */
public class Institucion {

    private int idInstitucion;
    private String nombre;
    private String correo;
    private String razonSocial;
    private boolean esReporteador;
    private String password;

    public Institucion(int idInstitucion, String nombre, String correo, String razonSocial, boolean esReporteador, String password) {
        this.idInstitucion = idInstitucion;
        this.nombre = nombre;
        this.correo = correo;
        this.razonSocial = razonSocial;
        this.esReporteador = esReporteador;
        this.password = password;
    }
    
    public Institucion() {

    }

    public int getIdInstitucion() {
        return idInstitucion;
    }

    public void setIdInstitucion(int idInstitucion) {
        this.idInstitucion = idInstitucion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public boolean isEsReporteador() {
        return esReporteador;
    }

    public void setEsReporteador(boolean esReporteador) {
        this.esReporteador = esReporteador;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
