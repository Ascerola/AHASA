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
public class Ciudadano extends Usuario{
    private int idCiudadano;
    private int cedula;
    private String correo;
    private String nombre;
    private String ape1;
    private String ape2;

    public Ciudadano(int idCiudadano, int cedula, String correo, String nombre, String ape1, String ape2, int idUsuario, String nombreUsuario, String password, String tipo) {
        super(idUsuario, nombreUsuario, password, tipo);
        this.idCiudadano = idCiudadano;
        this.cedula = cedula;
        this.correo = correo;
        this.nombre = nombre;
        this.ape1 = ape1;
        this.ape2 = ape2;
    }

    public Ciudadano(){   
    }

    public int getIdCiudadano() {
        return idCiudadano;
    }

    public void setIdCiudadano(int idCiudadano) {
        this.idCiudadano = idCiudadano;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }


    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApe1() {
        return ape1;
    }

    public void setApe1(String ape1) {
        this.ape1 = ape1;
    }

    public String getApe2() {
        return ape2;
    }

    public void setApe2(String ape2) {
        this.ape2 = ape2;
    }
           
}
