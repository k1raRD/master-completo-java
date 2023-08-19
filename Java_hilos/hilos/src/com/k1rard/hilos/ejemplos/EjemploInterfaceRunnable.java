package com.k1rard.hilos.ejemplos;

import com.k1rard.hilos.ejemplos.runnable.ViajeTarea;

public class EjemploInterfaceRunnable {
    public static void main(String[] args) {

        new Thread(new ViajeTarea("Isla de Pascua")).start();
        new Thread(new ViajeTarea("Robinson Crusos")).start();
        new Thread(new ViajeTarea("Juan fernandez")).start();
        new Thread(new ViajeTarea("Isla de Chiloe")).start();
    }
}
