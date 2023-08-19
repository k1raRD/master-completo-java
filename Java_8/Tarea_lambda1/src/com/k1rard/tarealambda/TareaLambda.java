package com.k1rard.tarealambda;

public class TareaLambda {
    public static void main(String[] args) {

        FormateoString formato = frase -> {
            return  frase.replace(".", "")
                    .replace(",", "")
                    .replace(" ", "");
        };

        String resultado = formato.formatearString("Esto es solo un texto de prueba, con algunas comas , y algunos puntos. . . .");
        System.out.println("resultado = " + resultado);
    }
}
