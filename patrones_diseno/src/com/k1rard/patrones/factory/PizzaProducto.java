package com.k1rard.patrones.factory;

import java.util.ArrayList;
import java.util.List;

abstract public class PizzaProducto {
    protected String nombre;
    protected String masa;
    protected String salsa;
    protected List<String> ingredientes;

    public PizzaProducto() {
        ingredientes = new ArrayList<>();
    }
    public void preparar(){
        System.out.println("Preparando: " + nombre);
        System.out.println("Seleccionando la masa: " + masa);
        System.out.println("Agregando la salsa:  " + salsa);
        System.out.println("Agregando ingredientes: ");
        this.ingredientes.forEach(System.out::println);
    }
    abstract public void cocinar();
    abstract public void cortar();
    public void empaquetar(){
        System.out.println("Pooniendo la pizza en una caja de empaque");
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "PizzaProducto{" +
                "nombre='" + nombre + '\'' +
                ", masa='" + masa + '\'' +
                ", salsa='" + salsa + '\'' +
                ", ingredientes=" + ingredientes +
                '}';
    }
}
