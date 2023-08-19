package com.k1rard.manejojson;
public class Bicicleta {
    private String marca;
    private String modelo;
    private int radioRueda;
    private int velocidades;
    private boolean personalizable;

    public Bicicleta(String marca, String modelo, int radioRueda, int velocidades, boolean personalizable) {
        this.marca = marca;
        this.modelo = modelo;
        this.radioRueda = radioRueda;
        this.velocidades = velocidades;
        this.personalizable = personalizable;
    }

    @Override
    public String toString() {
        return "Bicicleta [marca=" + marca + ", modelo=" + modelo + ", radioRueda=" + radioRueda + ", velocidades="
                + velocidades + ", personalizable=" + personalizable + "]";
    }

}
