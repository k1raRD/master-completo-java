package com.k1rard.ejemplos.list;

import com.k1rard.ejemplos.modelo.Alumno;

import java.util.ArrayList;
import java.util.List;

public class EjemploArrayListComparableComparator {
    public static void main(String[] args) {

        List<Alumno> al = new ArrayList<>();
        System.out.println(al + " Size = " + al.size());
        System.out.println("Esta vacia = " + al.isEmpty());
        al.add(new Alumno("Pato", 5.0));
        al.add(new Alumno("Cata", 6.0));
        al.add(new Alumno("Luci", 4.0));
        al.add(new Alumno("Zeus", 2.0));
        al.set(1, new Alumno("Lucas", 2.0));
        System.out.println(al + " Size = " + al.size());
        System.out.println("Esta vacia = " + al.isEmpty());
        System.out.println(al);

        //al.remove(new Alumno("Zeus", 2.0));
        al.remove(2);
        System.out.println(al + ", size = " + al.size());

        boolean b = al.contains(new Alumno("Zeus", 2.0));
        System.out.println("La lista contiene a Zeus: " + b);

        Object a[] = al.toArray();
        for(int i = 0; i < a.length; i++){
            System.out.println("Desde el arreglo = " + a[i]);
        }
    }
}
