package com.collado.tareamamiferos.domain;

public abstract class Felino extends Mamifero{
    protected float tamanoGarras;
    protected int velocidad;

    public Felino(String habitat, float altura, float largo, float peso, String nombreCientifico, float tamanoGarras, int velocidad) {
        super(habitat, altura, largo, peso, nombreCientifico);
        this.tamanoGarras = tamanoGarras;
        this.velocidad = velocidad;
    }

    @Override
    public String toString() {
        return super.toString() + " Felino{" +
                "tamanoGarras=" + tamanoGarras +
                ", velocidad=" + velocidad +
                '}';
    }
}
