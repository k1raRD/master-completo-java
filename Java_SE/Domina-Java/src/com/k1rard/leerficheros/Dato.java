package com.k1rard.leerficheros;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Dato {
    private static final NumberFormat NF = NumberFormat.getCurrencyInstance();
    private static final String PATRON = "EEEE, d 'de' MMMM 'de' yyyy";
    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern(PATRON);
    private String nombre;
    private LocalDate fecha;
    private int sueldo;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return this.nombre + " / " + DTF.format(this.fecha) + " / " + NF.format(sueldo);
    }
}
