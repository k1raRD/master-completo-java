package com.k1rard.random;
import java.security.SecureRandom;
import java.util.Random;
public class Suerte
{
    public static void main(String[] args) {
        System.out.println("... con Math.random()");
        for (int i = 0; i < 10; i ++) {
            double d = Math.random();
            System.out.print(d);
            System.out.print("\t" + (d <= 0.3));
            System.out.print("\t" + (int)(d * 10));
            System.out.println();
        }

        System.out.println("... con Random");
        Random r = new Random();
        Random s = new Random(987654321);
        Random t = new Random(987654321);
        System.out.println("... ... las semillas");
        for (int i = 0; i < 10; i ++) {
            int nr = r.nextInt();
            int ns = s.nextInt();
            int nt = t.nextInt();
            System.out.print(nr);
            System.out.print("\t" + ns);
            System.out.print("\t" + nt);
            System.out.println();
        }

        System.out.println("... ... varios tipos");
        for (int i = 0; i < 10; i ++) {
            int n = r.nextInt();
            int edad = r.nextInt(100);
            boolean b = r.nextBoolean();
            byte[] bytes = new byte[8];
            r.nextBytes(bytes);
            System.out.print(n);
            System.out.print("\t" + edad);
            System.out.print("\t" + b);
            System.out.print("\t" + new String(bytes));
            System.out.println();
        }

        System.out.println("... con SecureRandom");
        SecureRandom sr = new SecureRandom();
        for (int i = 0; i < 10; i ++) {
            int n = sr.nextInt();
            int edad = sr.nextInt(100);
            boolean b = sr.nextBoolean();
            System.out.print(n);
            System.out.print("\t" + edad);
            System.out.print("\t" + b);
            System.out.println();
        }

        System.out.println("Ejemplos concretos");
        int min = 50;
        int max = 150;
        System.out.println("Numeros entre " + min + " y " + max);
        for (int i = 0; i < 10; i ++) {
            int num = r.nextInt(max - min + 1) + min;
            System.out.print(num + " ");
        }
        System.out.println();

        min = -10;
        max = 10;
        System.out.println("Numeros entre " + min + " y " + max);
        for (int i = 0; i < 100; i ++) {
            int num = r.nextInt(max - min + 1) + min;
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.print("Nombre de niña: ");
        Nombres[] posibles = Nombres.values();
        int pos = r.nextInt(posibles.length);
        Nombres nombre = posibles[pos];
        System.out.println(nombre);

        System.out.println("Matriculas: ");
        char[] alfabeto = "BCDFGHJKLMNPRSTVWXYZ".toCharArray();
        for (int i = 0; i < 10; i ++) {
            r.ints(4, 0, 10)
                    .forEach(n -> System.out.print(n));
            r.ints(3, 0, alfabeto.length)
                    .forEach(n -> System.out.print(alfabeto[n]));
            System.out.println();
        }
    }
}

enum Nombres {
    MARIA, MARTA, MARINA, MARTINA, MAR;
}
