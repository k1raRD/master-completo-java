package com.k1rard.apiservlet.webapp.headers.models;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;

import java.io.Serializable;

@RequestScoped
public class Cliente implements Serializable {
    private String nombre;
    private String apellido;
    @PostConstruct
    public void inicializar(){
        nombre = "Alex";
        apellido = "Collado";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
