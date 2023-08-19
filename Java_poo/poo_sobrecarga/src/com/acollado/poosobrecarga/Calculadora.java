package com.acollado.poosobrecarga;

public class Calculadora {

    private Calculadora() {
    }

    public static int sumar(int a, int b){
        return a + b;
    }

    public static float sumar(float a, float b){
        return a + b;
    }

    public static float sumar(int a, float b){
        return a + b;
    }

    public static float sumar(float a, int b){
        return a + b;
    }

    public static double sumar(double a, double b){
        return a + b;
    }

    public static int sumar(String a, String b){
        int resultado;
        try {
        resultado =  Integer.parseInt(a) + Integer.parseInt(b);
        }catch (NumberFormatException e){
            resultado = 0;
        }
        return resultado;
    }

    public static int sumar(int a, int b, int c){
        return a + b + c;
    }

    public static int sumar(int ...argumento){
        int total = 0;
        for(int i: argumento){
            total += i;
        }
        return total;
    }

    public static double sumar(double ...argumento){
        double total = 0;
        for(double i: argumento){
            total += i;
        }
        return total;
    }

}
