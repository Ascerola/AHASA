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
    private String fechaIngreso;
    private String estado;
    private boolean valida;
    //if averia = valida  
    private String descSolucion;
    private int tiempoInvertido;
    private int empleadosInvolucrados;
    private double costo;
    private String responsable;
    //if averia = finalizada
    private int cantColaboradores;
    private String fechaArreglo;
    private String imagenRes;

    public Averia(int idAveria, int nivel, String provincia, String canton, String distrito, String direccion, String imagen, Institucion institucion, String descripcion, String fechaIn, String estado, boolean valida) {
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
        this.valida = valida;
        //if averia = valida       
        descSolucion = "";
        tiempoInvertido = 0;
        empleadosInvolucrados = 0;
        costo = 0;
        responsable = "";
        //if averia = finalizada
        cantColaboradores = 0;
        fechaArreglo = "12/12/12";
        imagenRes = "";
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

    public String getfechaIngreso() {
        return fechaIngreso;
    }

    public void setfechaIngreso(String fechaIn) {
        this.fechaIngreso = fechaIn;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    public boolean getValida() {
        return valida;
    }

    public void setValida(boolean valida) {
        this.valida = valida;
    }

    public String getDescSolucion() {
        return descSolucion;
    }

    public void setDescSolucion(String descSolucion) {
        this.descSolucion = descSolucion;
    }

    public int getTiempoInvertido() {
        return tiempoInvertido;
    }

    public void setTiempoInvertido(int tiempoInvertido) {
        this.tiempoInvertido = tiempoInvertido;
    }

    public int getEmpleadosInvolucrados() {
        return empleadosInvolucrados;
    }

    public void setEmpleadosInvolucrados(int empleadosInvolucrados) {
        this.empleadosInvolucrados = empleadosInvolucrados;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public int getCantColaboradores() {
        return cantColaboradores;
    }

    public void setCantColaboradores(int cantColaboradores) {
        this.cantColaboradores = cantColaboradores;
    }

    public String getFechaArreglo() {
        return fechaArreglo;
    }

    public void setFechaArreglo(String fechaArreglo) {
        this.fechaArreglo = fechaArreglo;
    }

    public String getImagenRes() {
        return imagenRes;
    }

    public void setImagenRes(String imagenRes) {
        this.imagenRes = imagenRes;
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

    public void pasarAFinalizada(int cant, String date) {
        if (estado.equals("Finalizada")) {
            cantColaboradores = cant;
            fechaArreglo = date;
        }
    }
}
