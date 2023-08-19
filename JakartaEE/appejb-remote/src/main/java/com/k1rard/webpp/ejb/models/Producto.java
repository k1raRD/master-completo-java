package com.k1rard.webpp.ejb.models;

import java.io.Serializable;

public class Producto implements Serializable {
    private static final long serialVersionUID = 411234873294917198L;
    private String nombre;
    public Producto(String nombre) {
        this.nombre = nombre;
    }
    public Producto() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
