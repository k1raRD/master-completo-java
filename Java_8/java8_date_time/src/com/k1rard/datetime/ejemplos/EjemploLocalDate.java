package com.k1rard.datetime.ejemplos;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class EjemploLocalDate {
    public static void main(String[] args) {

        LocalDate fechaActual = LocalDate.now();
        System.out.println("fechaActual = " + fechaActual);
        System.out.println("Dia = " + fechaActual.getDayOfMonth());
        Month mes = fechaActual.getMonth();
        System.out.println("Mes = " + mes);
        System.out.println("Numero del mes = " + mes.getValue());
        System.out.println("Mes spanish = " + mes.getDisplayName(TextStyle.FULL, new Locale("es" ,"ES")));

        DayOfWeek diaSemana = fechaActual.getDayOfWeek();
        System.out.println("Numero del dia = " + diaSemana.getValue());
        System.out.println("Nombre del dia = " + diaSemana.getDisplayName(TextStyle.FULL, new Locale("es", "ES")));
        System.out.println("Year = " + fechaActual.getYear());
        System.out.println("Dial del year = " + fechaActual.getDayOfYear());
        System.out.println("Era = " + fechaActual.getEra());

        fechaActual = LocalDate.of(2020, 1, 25);
        System.out.println("fechaActual = " + fechaActual);

        fechaActual = LocalDate.of(2020, Month.NOVEMBER, 11);
        System.out.println("fechaActual = " + fechaActual);

        fechaActual = LocalDate.parse("2020-02-01");
        System.out.println("fechaActual = " + fechaActual);

        LocalDate diaDeManana = LocalDate.now().plusDays(1);
        System.out.println("diaDeManana = " + diaDeManana);

//        LocalDate mesAnteriorMismoDia = LocalDate.now().minusMonths(1);
//        System.out.println("mesAnteriorMismoDia = " + mesAnteriorMismoDia);

        LocalDate mesAnteriorMismoDia = LocalDate.now().minus(1, ChronoUnit.MONTHS);
        System.out.println("mesAnteriorMismoDia = " + mesAnteriorMismoDia);

        DayOfWeek miercoles = LocalDate.parse("2020-11-11").getDayOfWeek();
        System.out.println("miercoles = " + miercoles);

        int once = LocalDate.of(2023, 11, 11).getDayOfMonth();
        System.out.println("once = " + once);

        boolean esBisiesto = LocalDate.now().isLeapYear();
        System.out.println("esBisiesto = " + esBisiesto);

        boolean esAntes = LocalDate.now().isBefore(LocalDate.parse("2020-11-10"));
        System.out.println("esAntes = " + esAntes);

        boolean esDespues = LocalDate.parse("2020-11-11").isAfter(LocalDate.now());
        System.out.println("esDespues = " + esDespues);

        esDespues = LocalDate.now().isAfter(LocalDate.now().minusDays(2));
        System.out.println("esDespues = " + esDespues);
    }
}
