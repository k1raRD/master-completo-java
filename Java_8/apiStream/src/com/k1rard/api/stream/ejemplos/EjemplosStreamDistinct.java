package com.k1rard.api.stream.ejemplos;

import com.k1rard.api.stream.ejemplos.models.Usuario;

import java.util.Optional;
import java.util.stream.Stream;

public class EjemplosStreamDistinct {
    public static void main(String[] args) {
           Stream<String> nombres =  Stream.of("Pato Guzman", "Paco Gonzales", "Pepa Gutierrez", "Pepe Mena", "Pepe Garcia", "Paco Gonzales", "Paco Gonzales", "Paco Gonzales")
                    .distinct();
                    nombres.forEach(System.out::println);

    }
}
