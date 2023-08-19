package com.k1rard.colores;

import java.text.Normalizer;

public class Coloreando {

    private static final Formato ROJO = new Formato(Color.ROJO, Decorado.NEGRITA, Enfasis.BRILLANTE);
    private static final Formato VERDE = new Formato(Color.VERDE, Decorado.NEGRITA, Enfasis.NORMAL);
    private static final Formato CIAN = new Formato(Color.CIAN, Decorado.CURSIVA, Enfasis.BRILLANTE);
    private static final Formato MAGENTA = new Formato(Color.MAGENTA, Decorado.NEGRITA, Enfasis.FONDO);
    public static void main(String[] args) {
        System.out.println("Coloreando...");

        System.out.println(ROJO + "Texto en rojo" + Formato.RESET);
        System.out.println(VERDE + "Texto en verde brillante" + Formato.RESET);
        System.out.println(MAGENTA + "Texto en magenta" + Formato.RESET);
        System.out.println(CIAN + "Texto en Cian" + Formato.RESET);

        int a = 5; int b = 6; int c = a = b;

        System.out.println(c);
    }
}
