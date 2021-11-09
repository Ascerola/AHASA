/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.TimeZone;

/**
 *
 * @author coke zero
 */
public class Averia {
    private int idAveria;
    private int nivel;
    private String provincia;
    private String canton;
    private String distrito;
    private String direccion;
    private String imagen;
    private Institucion institucion;    
    private String descripcion;
    private Date fechaIngreso;
    private String estado;
    //if averia = valida
    private String descSolucion;
    private int tiempoInvertido;
    private int empleadosInvolucrados;
    private double costo;
    private String responsable;
    //if averia = finalizada
    private int cantColaboradores;
    private Date fechaArreglo;

    public Averia(int idAveria, int nivel, String provincia, String canton, String distrito, String direccion, String imagen, Institucion institucion, String descripcion, Date fechaIn, String estado) {
        this.idAveria = idAveria;
        this.nivel = nivel;
        this.provincia = provincia;
        this.canton = canton;
        this.distrito = distrito;
        this.direccion = direccion;
        this.imagen = imagen;
        this.institucion = institucion;
        this.descripcion = descripcion;
        this.fechaIngreso = fechaIn;
        this.estado = estado;
        //if averia = valida
        descSolucion = "";
        tiempoInvertido = 0;
        empleadosInvolucrados = 0;
        costo = 0;
        responsable = "";
        //if averia = finalizada
        cantColaboradores = 0;
        fechaArreglo = Date.valueOf("12/12/12");
    }

    public Averia() {

    }

    public int getIdAveria() {
        return idAveria;
    }

    public void setIdAveria(int idAveria) {
        this.idAveria = idAveria;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Institucion getInstitucion() {
        return institucion;
    }

    public void setInstitucion(Institucion institucion) {
        this.institucion = institucion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getfechaIngreso() {
        return fechaIngreso;
    }

    public void setfechaIngreso(Date fechaIn) {
        this.fechaIngreso = fechaIn;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void pasarAValida(String desc, int horas, int involucrados, double costo, String resp) {
        if (estado.equals("Valida")) {
            this.descSolucion = desc;
            this.tiempoInvertido = horas;
            this.empleadosInvolucrados = involucrados;
            this.costo = costo;
            this.responsable = resp;
        }
    }

    public void pasarAFinalizada(int cant, Date date) {
        if (estado.equals("Finalizada")) {
            cantColaboradores = cant;
            fechaArreglo = date;
        }
    }

}
