package com.k1rard.ejemplos.set;

import com.k1rard.ejemplos.modelo.Alumno;

import java.util.*;

public class EjemploHashSetUnicidad {
    public static void main(String[] args) {
//        Set<Alumno> sa = new TreeSet<>();
        List<Alumno> sa = new ArrayList<>();
        sa.add(new Alumno("Pato", 5.0));
        sa.add(new Alumno("Cata", 6.0));
        sa.add(new Alumno("Luci", 4.0));
        sa.add(new Alumno("Zeus", 2.0));
        sa.add(new Alumno("Lucas", 2.0));
        sa.add(new Alumno("Lucas2", 2.0));
        sa.add(new Alumno("Lucas3", 2.0));
        sa.add(new Alumno("Zeus", 2.0));
        
        System.out.println(sa);

        System.out.println("Utilizando un for clasico");
        for (int i = 0; i < sa.size(); i++){
            System.out.println(sa.get(i));
        }

        System.out.println("Iterando usando forEach");
        for(Alumno a: sa){
            System.out.println("a = " + a.getNombre());
        }

        System.out.println("Iterando usando while y el iterator");
        Iterator<Alumno> it = sa.iterator();
        while (it.hasNext()){
            Alumno a = it.next();
            System.out.println(a.getNombre());
        }

        System.out.println("Iterando usando Stream foreach");
        sa.forEach(a -> System.out.println(a));

//        sa.forEach(System.out::println);

    }
}
