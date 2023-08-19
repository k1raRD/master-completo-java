package com.acollado.almacenverduleria.domain;

public class Fruta extends Producto{

    private double peso;
    private String color;

    public Fruta(String nombre, double precio) {
        super(nombre, precio);
    }

    public Fruta(String nombre, double precio, double peso, String color) {
        super(nombre, precio);
        this.peso = peso;
        this.color = color;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return super.toString() + " Fruta{" +
                "peso=" + peso +
                ", color='" + color + '\'' +
                '}';
    }
}
