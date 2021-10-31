/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

/**
 *
 * @author coke zero
 */
public class Helpers {
    /**
     * Convierte de util.date a sql.date
     *
     * @param date
     * @return
     */
    public java.sql.Date convert(java.util.Date date) {
        return new java.sql.Date(date.getTime());
    }
    /**
     * Obtener fecha actual de la maquina
     * @return @throws ParseException
     */
    public Date fechaActual() throws ParseException {
        //Instanciamos el objeto Calendar
        //en fecha obtenemos la fecha y hora del sistema
        Calendar fecha = Calendar.getInstance(TimeZone.getDefault());
        String dia = String.valueOf(fecha.get(Calendar.DAY_OF_MONTH));
        String mes = String.valueOf(fecha.get(Calendar.MONTH) + 1);
        String año = String.valueOf(fecha.get(Calendar.YEAR));
        String fechaActual = dia + "/" + mes + "/" + año;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy"); // New Pattern
        java.util.Date date = format.parse(fechaActual); // Returns a Date format object with the pattern
        java.sql.Date sqlfechaActual = new java.sql.Date(date.getTime());
        return sqlfechaActual;
    }
    /**
     * Obtner hora actual de la maquina
     * @return
     * @throws ParseException 
     */
    public Date horaActual() throws ParseException {
        //Instanciamos el objeto Calendar
        //en fecha obtenemos la fecha y hora del sistema
        Calendar fecha = Calendar.getInstance();
        String hora = String.valueOf(fecha.get(Calendar.HOUR_OF_DAY));
        String minuto = String.valueOf(fecha.get(Calendar.MINUTE));
        String horaActual = hora + ":" + minuto;
        SimpleDateFormat format = new SimpleDateFormat("HH:mm", Locale.getDefault()); // New Pattern
        java.util.Date date = format.parse(horaActual); // Returns a Date format object with the pattern
        java.sql.Date sqlhoraActual = new java.sql.Date(date.getTime());
        return sqlhoraActual;
    }
}
