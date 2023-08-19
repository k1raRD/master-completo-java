package com.k1rard.patrones.decorator.decoradores;

import com.k1rard.patrones.decorator.Formateable;

public class RemplazarEspacioDecorador extends TextoDecorador{
    public RemplazarEspacioDecorador(Formateable texto) {
        super(texto);
    }


    @Override
    public String darFormato() {
        return texto.darFormato().replace(" ", "_");
    }
}
