package com.k1rard.datetime.ejemplos;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class EjemploLocalDateTime {
    public static void main(String[] args) {

        LocalDateTime fechaCompleta = LocalDateTime.now();
        System.out.println("fechaCompleta = " + fechaCompleta);

        fechaCompleta = LocalDateTime.of(2023, Month.AUGUST, 24, 20, 45, 12);
        System.out.println("fechaCompleta = " + fechaCompleta);

        fechaCompleta = LocalDateTime.parse("2023-12-25T07:32");
        System.out.println("fechaCompleta = " + fechaCompleta);

        LocalDateTime fechaCompleta2 = fechaCompleta.plusDays(1).plusHours(3);
        System.out.println("fechaCompleta = " + fechaCompleta);
        System.out.println("fechaCompleta2 = " + fechaCompleta2);
        System.out.println("fechaCompleta2.minusHours(4) = " + fechaCompleta2.minusHours(4));

        Month mes = fechaCompleta.getMonth();
        System.out.println("mes = " + mes);

        int dia = fechaCompleta2.getDayOfMonth();
        System.out.println("dia = " + dia);

        int anio = fechaCompleta2.getYear();
        System.out.println("anio = " + anio);

        String formato1 = fechaCompleta.format(DateTimeFormatter.ISO_DATE);
        System.out.println("formato1 = " + formato1);

        String formato2 = fechaCompleta.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
        System.out.println("formato2 = " + formato2);

        String formato3 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(fechaCompleta2);
        System.out.println("formato3 = " + formato3);
    }
}
