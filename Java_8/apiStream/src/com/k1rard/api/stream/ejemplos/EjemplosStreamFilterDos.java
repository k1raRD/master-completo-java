package com.k1rard.api.stream.ejemplos;

import com.k1rard.api.stream.ejemplos.models.Usuario;

import java.util.Optional;
import java.util.stream.Stream;

public class EjemplosStreamFilterDos {
    public static void main(String[] args) {

        // Asignado el stream a una variable
//        Stream<String> nombres = Stream.of("Pato", "Paco", "Pepa", "Pepa")
//                .peek(e -> System.out.println(e))
//                .map(nombre -> {
//            return nombre.toUpperCase();
//        });
//        nombres.forEach(System.out::println);

        // Sin asignar el stream a ninguna variable
//        Stream.of("Pato", "Paco", "Pepa", "Pepa")
//                .map(nombre -> {
//                    return nombre.toUpperCase();
//                }).forEach(System.out::println);

        Usuario usuario  = Stream
                .of("Pato Guzman", "Paco Gonzales", "Pepa Gutierrez", "Pepe Mena", "Pepe Garcia")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .peek(System.out::println)
                .filter(u -> u.getId().equals(3))
                .findFirst().orElseGet(() -> new Usuario("John", "Doe"));

        System.out.println(usuario);



    }
}
