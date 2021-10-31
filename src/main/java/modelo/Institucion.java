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
    private String password;
    private boolean esReporteador;

    public Institucion(int idInstitucion, String nombre, String correo, String razonSocial, String password, boolean esReporteador) {
        this.idInstitucion = idInstitucion;
        this.nombre = nombre;
        this.correo = correo;
        this.razonSocial = razonSocial;
        this.password = password;
        this.esReporteador = esReporteador;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEsReporteador() {
        return esReporteador;
    }

    public void setEsReporteador(boolean esReporteador) {
        this.esReporteador = esReporteador;
    }

}
