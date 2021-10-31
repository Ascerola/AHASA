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
public class AveriaValida {
    private Averia averia;
    private String descSolucion;
    private int horasInvertidas;
    private int empleadosInvolucrados;
    private double costo;
    private String responsable;
    private String imagen;

    public AveriaValida(Averia averia, String descSolucion, int horasInvertidas, int empleadosInvolucrados, double costo, String responsable, String imagen) {
        this.averia = averia;
        this.descSolucion = descSolucion;
        this.horasInvertidas = horasInvertidas;
        this.empleadosInvolucrados = empleadosInvolucrados;
        this.costo = costo;
        this.responsable = responsable;
        this.imagen = imagen;
    }
    public AveriaValida() {
       
    }

    public Averia getAveria() {
        return averia;
    }

    public void setAveria(Averia averia) {
        this.averia = averia;
    }

    public String getDescSolucion() {
        return descSolucion;
    }

    public void setDescSolucion(String descSolucion) {
        this.descSolucion = descSolucion;
    }

    public int getHorasInvertidas() {
        return horasInvertidas;
    }

    public void setHorasInvertidas(int horasInvertidas) {
        this.horasInvertidas = horasInvertidas;
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

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
}
