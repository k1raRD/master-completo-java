package com.k1rard.api.stream.ejemplos;

import java.util.stream.Stream;

public class EjemplosStreamReduceEnteros {
    public static void main(String[] args) {
           Stream<Integer> nombres =  Stream.of(5,10,15,20,25,30);

           Integer resultado = nombres.reduce(0, Integer::sum);
            System.out.println("resultado = " + resultado);

    }
}
