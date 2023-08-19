package com.k1rard.patrones.observer.ejemplo;

import com.k1rard.patrones.observer.Corporacion;
import com.k1rard.patrones.observer.Observable;

public class EjemploObserver {
    public static void main(String[] args) {
        Corporacion google = new Corporacion("Google", 1000);
        google.addObserver((observable, obj) -> {
            System.out.println("John: " + observable);
        });

        google.addObserver((observable, obj) -> {
            System.out.println("Andres: " + observable);
        });

        google.addObserver((observable, obj) -> {
            System.out.println("Maria: " + observable);
        });
        google.modificarPrecio(2000);
    }
}
