package com.k1rard.datetime.ejemplos;

import java.time.Duration;
import java.time.LocalDateTime;

public class EjemploDuration {
    public static void main(String[] args) {

        LocalDateTime fecha1 = LocalDateTime.now();
        LocalDateTime fecha2 = LocalDateTime.now().minusHours(3).plusMinutes(20).plusDays(2);

        Duration lapso = Duration.between(fecha1, fecha2);
        System.out.println("lapso = " + lapso);
        System.out.println("lapso = " + lapso.toMinutes());
        System.out.println("lapso = " + lapso.plusHours(4));

    }
}
