package com.collado.tareamamiferos.domain.caninos;

import com.collado.tareamamiferos.domain.Canino;

public class Lobo extends Canino {

    private int numManada;
    private String especieLobo;

    public Lobo(String habitat, float altura, float largo, float peso, String nombreCientifico, String color, float tamanoColmillos, int numManada, String especieLobo) {
        super(habitat, altura, largo, peso, nombreCientifico, color, tamanoColmillos);
        this.numManada = numManada;
        this.especieLobo = especieLobo;
    }

    public int getNumManada() {
        return numManada;
    }

    public void setNumManada(int numManada) {
        this.numManada = numManada;
    }

    public String getEspecieLobo() {
        return especieLobo;
    }

    public void setEspecieLobo(String especieLobo) {
        this.especieLobo = especieLobo;
    }

    @Override
    public String comer() {
        return "Soy un lobo y me gusta cazar en las montanas";
    }

    @Override
    public String dormir() {
        return "Soy un lobo y me gusta dormir por el dia";
    }

    @Override
    public String correr() {
        return "Soy un lobo y me gusta corren con el jaguar";
    }

    @Override
    public String comunicarse() {
        return "Soy un lobo y me comunico mediante aullidos";
    }

    @Override
    public String toString() {
        return super.toString() + " Lobo{" +
                "numManada=" + numManada +
                ", especieLobo='" + especieLobo + '\'' +
                '}';
    }
}
