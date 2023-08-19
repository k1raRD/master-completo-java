package com.k1rard.apiservlet.webapp.headers.models;

public class ProductoTarea {

    private String nombre;
    private Integer precio;

    public ProductoTarea(String nombre, Integer precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }
}
