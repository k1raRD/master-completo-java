package com.k1rard.lambda.aritmetica;

import java.util.function.BiFunction;

public class Calculadora {

    public double computar(double a, double b, Aritmetic lambda){
        return lambda.operacion(a, b);
    }

    public double computarConBiFunction(double a, double b, BiFunction<Double, Double, Double> lambda){
        return lambda.apply(a,b);
    }
}
