package com.collado.tareamamiferos.domain.felinos;

import com.collado.tareamamiferos.domain.Felino;

public class Guepardo extends Felino {

    public Guepardo(String habitat, float altura, float largo, float peso, String nombreCientifico, float tamanoGarras, int velocidad) {
        super(habitat, altura, largo, peso, nombreCientifico, tamanoGarras, velocidad);
    }

    @Override
    public String comer() {
        return "Soy un guepardo y como mucha carne";
    }

    @Override
    public String dormir() {
        return "Soy un guepardo, solo duermo 2 horas";
    }

    @Override
    public String correr() {
        return "Soy un guepardo y soy el felino que mas corre";
    }

    @Override
    public String comunicarse() {
        return "Soy un guepardo y me comunico con mis presas";
    }

    @Override
    public String toString() {
        return "Guepardo{"+ super.toString() +"}";
    }
}
