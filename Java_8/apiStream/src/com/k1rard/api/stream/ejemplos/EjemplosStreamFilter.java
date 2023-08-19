package com.k1rard.api.stream.ejemplos;

import com.k1rard.api.stream.ejemplos.models.Usuario;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EjemplosStreamFilter {
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

        Stream<Usuario> nombres = Stream
                .of("Pato Guzman", "Paco Gonzales", "Pepa Gutierrez", "Pepe Mena", "Pepe Garcia")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .filter(u -> u.getNombre().equals("Pepe"))
                .peek(u -> System.out.println(u));
                //.peek(System.out::println);
        List<Usuario> lista = nombres.collect(Collectors.toList());
        lista.forEach(u -> System.out.println(u));
        //nombres.forEach(System.out::println);


    }
}
