package com.k1rard.datetime.ejemplos;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class EjemploLocalTime {
    public static void main(String[] args) {

        LocalTime hora = LocalTime.now();
        System.out.println("hora = " + hora);
        System.out.println("hora.getHour() = " + hora.getHour());
        System.out.println("hora.getMinute() = " + hora.getMinute());
        System.out.println("hora.getSecond() = " + hora.getSecond());
        System.out.println("hora.getNano() = " + hora.getNano());
        LocalTime seisConTreinta = LocalTime.of(6, 30, 59);
        System.out.println("seisConTreinta = " + seisConTreinta);
        seisConTreinta = LocalTime.parse("06:30");

        System.out.println("seisConTreinta = " + seisConTreinta);
        LocalTime sieteConTreinta = LocalTime.of(6,30).plus(1, ChronoUnit.HOURS);
        System.out.println("sieteConTreinta = " + sieteConTreinta);
        boolean esAnterior = LocalTime.of(6, 30).isBefore(sieteConTreinta);
        System.out.println("esAnterior = " + esAnterior);
        LocalTime ahora = LocalTime.now();

        DateTimeFormatter df = DateTimeFormatter.ofPattern("hh:mm:ss a");
        String ahoraFormateado = seisConTreinta.format(df);
        System.out.println("ahoraFormateado = " + ahoraFormateado);

        LocalTime max = LocalTime.MAX;
        LocalTime min = LocalTime.MIN;
        System.out.println("max = " + max);
        System.out.println("min = " + min);

    }
}
