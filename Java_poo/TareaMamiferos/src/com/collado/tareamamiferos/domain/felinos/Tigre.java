package com.collado.tareamamiferos.domain.felinos;

import com.collado.tareamamiferos.domain.Felino;

public class Tigre extends Felino {

    private String especie;


    public Tigre(String habitat, float altura, float largo, float peso, String nombreCientifico, float tamanoGarras, int velocidad, String especie) {
        super(habitat, altura, largo, peso, nombreCientifico, tamanoGarras, velocidad);
        this.especie = especie;
    }

    public String getEspecie() {
        return especie;
    }

    @Override
    public String comer() {
        return "Soy un tigre solo me gusta comer carne";
    }

    @Override
    public String dormir() {
        return "Soy un tigre solo duermo 2 horas.";
    }

    @Override
    public String correr() {
        return "Soy un tigre no corro mucho como parece";
    }

    @Override
    public String comunicarse() {
        return "Soy un tigre, me comunico mediante grunidos";
    }

    @Override
    public String toString() {
        return super.toString() + " Tigre{" +
                "especie='" + especie + '\'' +
                '}';
    }
}
