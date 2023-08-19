package com.k1rard.lambda;

import com.k1rard.lambda.aritmetica.Aritmetic;
import com.k1rard.lambda.aritmetica.Calculadora;

public class EjemploInterfaceFunctional {
    public static void main(String[] args) {
        Aritmetic suma = (a, b) -> a + b;
        Aritmetic resta = (a,b) -> a - b ;

        Calculadora cal = new Calculadora();
        System.out.println(cal.computar(10, 5, suma));
        System.out.println(cal.computar(10,5,resta));
        System.out.println(cal.computar(10,5, (a, b) -> a * b));
        System.out.println(cal.computarConBiFunction(10,5, Double::sum));
    }
}
