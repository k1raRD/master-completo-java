package com.k1rard.api.stream.ejemplos;

import com.k1rard.api.stream.ejemplos.models.Usuario;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EjemplosStreamDistinctUsuarioSum {
    public static void main(String[] args) {
        IntStream largroNombres = Stream
                .of("Pato Guzman", "Paco Gonzales", "Paco Gonzales", "Pepa Gutierrez", "Pepe Mena", "Pepe Garcia")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .distinct()
                .mapToInt(u -> u.toString().length())
                .peek(System.out::println);

        //largroNombres.forEach(System.out::println);
        IntSummaryStatistics statistics = largroNombres.summaryStatistics();
        System.out.println("total: " + statistics.getSum());
        System.out.println("Max: " + statistics.getMax());
        System.out.println("Min: " + statistics.getMin());
        System.out.println("Average: " + statistics.getAverage());
    }
}
