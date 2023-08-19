package com.k1rard.webapp.jaxws.models;

public class Curso {
    private String nombre;

    public Curso(String nombre) {
        this.nombre = nombre;
    }

    public Curso() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
