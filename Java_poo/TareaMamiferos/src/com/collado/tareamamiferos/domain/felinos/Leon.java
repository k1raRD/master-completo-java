package com.collado.tareamamiferos.domain.felinos;

import com.collado.tareamamiferos.domain.Felino;

public class Leon extends Felino {

    private int numeroManada;
    private float potenciaRugidorDecibel;

    public Leon(String habitat, float altura, float largo, float peso, String nombreCientifico, float tamanoGarras, int velocidad, int numeroManada, float potenciaRugidorDecibel) {
        super(habitat, altura, largo, peso, nombreCientifico, tamanoGarras, velocidad);
        this.numeroManada = numeroManada;
        this.potenciaRugidorDecibel = potenciaRugidorDecibel;
    }

    public int getNumeroManada() {
        return numeroManada;
    }

    public float getPotenciaRugidorDecibel() {
        return potenciaRugidorDecibel;
    }

    @Override
    public String comer() {
        return "Soy un leon haragan, solo como cuando aparece";
    }

    @Override
    public String dormir() {
        return "Soy un leon y siempre estoy durmiendo";
    }

    @Override
    public String correr() {
        return "Soy un leon no corro mucho";
    }

    @Override
    public String comunicarse() {
        return "Soy un leon y me comunico con grunidos";
    }
}
