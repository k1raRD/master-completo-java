package com.k1rard.api.stream.ejemplos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class EjemplosStream {
    public static void main(String[] args) {

        Stream<String> nombres = Stream.of("Pato", "Paco", "Pepa", "Pepa");
        //nombres.forEach(System.out::println);

        //String[] arr = {"Pato", "Paco", "Pepa", "Pepa"};
        //Stream<String> nombres2 = Arrays.stream(arr);
        //nombres2.forEach(e -> System.out.println(e));

//        Stream<String> nombres3 = Stream.<String>builder()
//                .add("Pato")
//                .add("Paco")
//                .add("Pepa")
//                .add("Pepe")
//                .build();
//        nombres3.forEach(System.out::println);

        List<String> lista = new ArrayList<>();
        lista.add("Pato");
        lista.add("Paco");
        lista.add("Pepe");
        lista.add("Pepa");

//        Stream<String> nombres4 = lista.stream();
//        nombres4.forEach(System.out::println);

        lista.stream().forEach(System.out::println);
    }
}
