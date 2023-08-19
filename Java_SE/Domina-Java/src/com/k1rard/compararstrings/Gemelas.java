package com.k1rard.compararstrings;

import java.util.ArrayList;
import java.util.List;

public class Gemelas
{
    public static final void main(String[] args) {
        int tres = 3;
        int multitud = 2 + 1;
        System.out.println("\t\tA\tB\t==\tequals");
        System.out.println("int\t\t"
                + tres + "\t" + multitud
                + "\t" + (tres == multitud)
                + "\tN/A");

        boolean cierto = true;
        boolean verdadero = 3 > 0;
        System.out.println("boolean\t\t"
                + cierto + "\t" + verdadero
                + "\t" + (cierto == verdadero)
                + "\tN/A");

        String ey = "hola";
        String saludo = "hola";
        System.out.println("String lit\t"
                + ey + "\t" + saludo
                + "\t" + (ey == saludo)
                + "\t" + ey.equals(saludo));

        String grito = "HOLA".toLowerCase();
        System.out.println("String\t\t"
                + ey + "\t" + grito
                + "\t" + (ey == grito)
                + "\t" + ey.equals(grito));

        List<String> lista = new ArrayList<>();
        List<String> listado = new ArrayList<>();
        lista.add(saludo);
        listado.add(saludo);
        System.out.println("List\t\t"
                + lista + "\t" + listado
                + "\t" + (lista == listado)
                + "\t" + lista.equals(listado));

        Integer dos = 2;
        Integer par = new Integer(saludo.length() / dos);
        System.out.println("Integer\t\t"
                + dos + "\t" + par
                + "\t" + (dos == par)
                + "\t" + dos.equals(par));

        Boolean falso = Boolean.FALSE;
        Boolean mentira = new Boolean(3 < 0);
        System.out.println("Boolean\t\t"
                + falso + "\t" + mentira
                + "\t" + (falso == mentira)
                + "\t" + falso.equals(mentira));
    }
}
