package com.k1rard.api.stream.ejemplos;

import java.util.stream.Stream;

public class EjemplosStreamReduce {
    public static void main(String[] args) {
           Stream<String> nombres =  Stream.of("Pato Guzman", "Paco Gonzales", "Pepa Gutierrez", "Pepe Mena", "Pepe Garcia", "Paco Gonzales", "Paco Gonzales", "Paco Gonzales")
                    .distinct();

           String resultado = nombres.reduce("Resultado concatenacion ", (a,b) -> a + "," + b);
        System.out.println("resultado = " + resultado);

    }
}
