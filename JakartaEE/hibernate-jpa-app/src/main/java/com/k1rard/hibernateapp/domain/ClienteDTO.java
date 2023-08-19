package com.k1rard.hibernateapp.domain;

public class ClienteDTO {
    private String nombre;
    private String apellido;

    public ClienteDTO(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }
}
