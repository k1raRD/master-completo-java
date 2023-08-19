package com.k1rard.ejemplos.set;

import com.k1rard.ejemplos.modelo.Alumno;

import static java.util.Comparator.comparing;
import java.util.Set;
import java.util.TreeSet;

public class EjemploTreeSetComparable {
    public static void main(String[] args) {
        //Set<Alumno> sa = new TreeSet<>((a,b) -> b.getNombre().compareTo(a.getNombre()));
        //Set<Alumno> sa = new TreeSet<>(Comparator.comparing(Alumno::getNota).reversed());
        Set<Alumno> sa = new TreeSet<>(comparing(Alumno::getNota).reversed());
        sa.add(new Alumno("Pato", 5.0));
        sa.add(new Alumno("Cata", 6.0));
        sa.add(new Alumno("Luci", 4.0));
        sa.add(new Alumno("Zeus", 2.0));
        sa.add(new Alumno("Lucas", 2.0));
        sa.add(new Alumno("Lucas2", 2.0));
        sa.add(new Alumno("Lucas3", 2.0));
        sa.add(new Alumno("Zeus", 2.0));

        System.out.println(sa);
    }
}
