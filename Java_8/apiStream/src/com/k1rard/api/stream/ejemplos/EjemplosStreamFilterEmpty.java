package com.k1rard.api.stream.ejemplos;

import com.k1rard.api.stream.ejemplos.models.Usuario;

import java.util.Optional;
import java.util.stream.Stream;

public class EjemplosStreamFilterEmpty {
    public static void main(String[] args) {
        long conunt = Stream
                .of("Pato Guzman", "Paco Gonzales", "", "Pepe Mena", "")
                .filter(String::isEmpty)
                .peek(n -> System.out.println(n))
                .count();

        System.out.println(conunt);
    }
}
