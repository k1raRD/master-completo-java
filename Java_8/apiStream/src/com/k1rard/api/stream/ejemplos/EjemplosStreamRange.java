package com.k1rard.api.stream.ejemplos;

import java.util.IntSummaryStatistics;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class EjemplosStreamRange {
    public static void main(String[] args) {
        //IntStream num =  IntStream.range(5, 20).peek(System.out::println);
        IntStream num =  IntStream.rangeClosed(5, 20).peek(System.out::println);
//        LongStream num =  LongStream.range(5, 20).peek(System.out::println);
//        DoubleStream num =  DoubleStream.iterate(5, 20).peek(System.out::println);

        //Integer resultado = num.reduce(0, Integer::sum);
        //int resultado = num.sum();
        IntSummaryStatistics statistics = num.summaryStatistics();
//        System.out.println("resultado = " + resultado);
        System.out.println("Max: = " + statistics.getMax());
        System.out.println("Min: = " + statistics.getMin());
        System.out.println("Sum: = " + statistics.getSum());
        System.out.println("Average: = " + statistics.getAverage());
        System.out.println("Total: = " + statistics.getCount());

    }
}
