package com.k1rard.patrones.decorator;

import com.k1rard.patrones.decorator.decoradores.MayusculaDecorador;
import com.k1rard.patrones.decorator.decoradores.ReversaDecorador;
import com.k1rard.patrones.decorator.decoradores.SubrayadoDecorador;

public class EjemploDecorador {
    public static void main(String[] args) {
        Formateable texto = new Texto("Hola que tal Andres");

        MayusculaDecorador mayusculaDecorador = new MayusculaDecorador(texto);
        ReversaDecorador reversaDecorador = new ReversaDecorador(mayusculaDecorador);
        SubrayadoDecorador subrayadoDecorador = new SubrayadoDecorador(reversaDecorador);

        System.out.println(subrayadoDecorador.darFormato());
    }
}
