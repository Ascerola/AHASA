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
public class AveriaInversion {
    private Averia averia;
    private double costo;
    private int tiempoInvertido;
    private int cantColaboradores;
    private String fechaArreglo;

    public AveriaInversion(Averia averia, double costo, int tiempoInvertido, int cantColaboradores, String fechaArreglo) {
        this.averia = averia;
        this.costo = costo;
        this.tiempoInvertido = tiempoInvertido;
        this.cantColaboradores = cantColaboradores;
        this.fechaArreglo = fechaArreglo;
    }
    public AveriaInversion() {
       
    }

    public Averia getAveria() {
        return averia;
    }

    public void setAveria(Averia averia) {
        this.averia = averia;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public int getTiempoInvertido() {
        return tiempoInvertido;
    }

    public void setTiempoInvertido(int tiempoInvertido) {
        this.tiempoInvertido = tiempoInvertido;
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
    
}
