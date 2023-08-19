package com.k1rard.imprimirobjetos;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;

public class Ficha
{
    private String nombre;
    private int num;
    private Collection<Ficha> coleccion;
    private LocalDateTime fecha;

    public Ficha(String nombre, int num, Ficha... elems) {
        this.nombre = nombre;
        this.num = num;
        coleccion = new HashSet<>();
        if (elems != null) {
            for (Ficha elem : elems) {
                coleccion.add(elem);
            }
        }
        fecha = LocalDateTime.now();
    }

    public static void main(String[] args) {
        Ficha ficha1 = new Ficha("azul", 235, (Ficha [])null);
        Ficha ficha2 = new Ficha("rojo", 18, ficha1);
        Ficha ficha3 = new Ficha("verde", 2318, ficha1, ficha2);
        ficha1.addFicha(ficha3);
        System.out.println(ficha1);
        System.out.println(ficha2);
        System.out.println(ficha3);
    }

    @Override
    public String toString() {
        return "soy una ficha " + nombre + " (" + num + ") de "
                + fecha + " con \n\t" + coleccion; //.size() + " fichas";
    }

    private void addFicha(Ficha ficha) {
        coleccion.add(ficha);
    }
}

