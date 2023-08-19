package com.k1rard.ejemplos.list;

import com.k1rard.ejemplos.modelo.Alumno;

import java.util.*;

public class EjemploListComparableComparator {
    public static void main(String[] args) {

        List<Alumno> sa = new ArrayList<>();
        sa.add(new Alumno("Pato", 5.0));
        sa.add(new Alumno("Cata", 6.0));
        sa.add(new Alumno("Luci", 4.0));
        sa.add(new Alumno("Zeus", 2.0));
        sa.add(new Alumno("Lucas", 2.0));
        sa.add(new Alumno("Lucas2", 2.0));
        sa.add(new Alumno("Lucas3", 2.0));
        sa.add(new Alumno("Zeus", 2.0));
       // Collections.sort(sa, (a, b) ->  b.getNota().compareTo(a.getNota()));
        //sa.sort((a, b) ->  b.getNota().compareTo(a.getNota()));
        sa.sort(Comparator.comparing((Alumno a) -> a.getNota()).reversed());
        sa.sort(Comparator.comparing(Alumno::getNota).reversed());
        System.out.println(sa);


        System.out.println("Iterando usando Stream foreach");
        sa.forEach(a -> System.out.println(a));
//        sa.forEach(System.out::println);

    }
}
