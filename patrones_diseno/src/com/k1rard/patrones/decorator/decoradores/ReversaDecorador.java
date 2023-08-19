package com.k1rard.patrones.decorator.decoradores;

import com.k1rard.patrones.decorator.Formateable;

public class ReversaDecorador extends TextoDecorador{
    public ReversaDecorador(Formateable texto) {
        super(texto);
    }

    @Override
    public String darFormato() {
        StringBuilder sb = new StringBuilder(texto.darFormato());
        return sb.reverse().toString();
    }
}
