package com.acollado.poosobrecarga;

public class EjemploSobrecarga {
    public static void main(String[] args) {
        System.out.println("Sumar enteros: " + Calculadora.sumar(4,3));
        System.out.println("Sumar float: " + Calculadora.sumar(10f, 20f));
        System.out.println("Sumar float-int: " + Calculadora.sumar(10f, 32));
        System.out.println("Sumar int-float: " + Calculadora.sumar(10, 4.3f));
        System.out.println("Sumar double: " + Calculadora.sumar(10.0, 5.0));
        System.out.println("Sumar string: " + Calculadora.sumar("23", "32"));
        System.out.println("Sumar 3 enteros: " + Calculadora.sumar(23,32,32));

        System.out.println("Suma long: "+ Calculadora.sumar(98l, 7l));
        System.out.println("Sumar char: "+ Calculadora.sumar(56, '@'));
        System.out.println("Sumar 7" + Calculadora.sumar(2,34,5,2,3,41,3));
        System.out.println("Sumar 8 double: " + Calculadora.sumar(2.3,4.5,6.6,9.5,54.3));
    }
}
