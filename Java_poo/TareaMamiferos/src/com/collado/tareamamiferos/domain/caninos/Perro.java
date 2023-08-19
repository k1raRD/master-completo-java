package com.collado.tareamamiferos.domain.caninos;

import com.collado.tareamamiferos.domain.Canino;

public class Perro extends Canino {

    private int fuerzaMordida;

    public Perro(String habitat, float altura, float largo, float peso, String nombreCientifico, String color, float tamanoColmillos, int fuerzaMordida) {
        super(habitat, altura, largo, peso, nombreCientifico, color, tamanoColmillos);
        this.fuerzaMordida = fuerzaMordida;
    }

    public int getFuerzaMordida() {
        return fuerzaMordida;
    }

    public void setFuerzaMordida(int fuerzaMordida) {
        this.fuerzaMordida = fuerzaMordida;
    }

    @Override
    public String comer() {
        return "Soy un perro y como cuando mi amo me da";
    }

    @Override
    public String dormir() {
        return "Soy un perro y duermo todo el dia";
    }

    @Override
    public String correr() {
        return "Soy un perro y me gusta correr mucho";
    }

    @Override
    public String comunicarse() {
        return "Soy un perro y ladro para comunicarme";
    }

    @Override
    public String toString() {
        return super.toString() + " Perro{" +
                "fuerzaMordida=" + fuerzaMordida +
                '}';
    }
}
