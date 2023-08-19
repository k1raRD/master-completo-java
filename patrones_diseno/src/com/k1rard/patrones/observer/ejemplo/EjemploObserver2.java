package com.k1rard.patrones.observer.ejemplo;

import com.k1rard.patrones.observer.UsuarioRepositorio;

public class EjemploObserver2 {
    public static void main(String[] args) {
        UsuarioRepositorio repo = new UsuarioRepositorio();
        repo.addObserver((o, usuario) -> System.out.println("Enviando un email al usuario " + usuario));
        repo.addObserver((o, usuario) -> System.out.println("Enviando un email al administrador"));
        repo.addObserver((o, usuario) -> System.out.println("Guardando info del usuario " + usuario +" en los logs"));
        repo.crearUsuario("Andres");
    }
}
