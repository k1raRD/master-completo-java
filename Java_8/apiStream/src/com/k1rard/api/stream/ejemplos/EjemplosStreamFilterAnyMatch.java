package com.k1rard.api.stream.ejemplos;

import com.k1rard.api.stream.ejemplos.models.Usuario;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class EjemplosStreamFilterAnyMatch {
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

        boolean existe  = Stream
                .of("Pato Guzman", "Paco Gonzales", "Pepa Gutierrez", "Pepe Mena", "Pepe Garcia")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .peek(System.out::println)
                .anyMatch(u -> u.getId().equals(3));

        System.out.println(existe);


        List<Usuario> lista = Arrays.asList(new Usuario("Pato", "Guzman"),
                new Usuario("Paco", "Gonzales"),
                new Usuario("Pepa", "Gutierrez"),
                new Usuario("Pepe", "Mena"),
                new Usuario("Pepe", "Garcia"));

        boolean resultado = false;
        for(Usuario u : lista){
            if(u.getId().equals(3)){
                resultado = true;
                break;
            }
        }
        System.out.println(resultado);
    }
}
