package com.k1rard.ejemplos.list;

import com.k1rard.ejemplos.modelo.Alumno;

import java.util.LinkedList;
import java.util.ListIterator;

public class EjemploLinkedList {
    public static void main(String[] args) {

        LinkedList<Alumno> enlazada = new LinkedList<>();
        System.out.println(enlazada + " Size = " + enlazada.size());
        System.out.println("Esta vacia = " + enlazada.isEmpty());
        enlazada.add(new Alumno("Pato", 5.0));
        enlazada.add(new Alumno("Cata", 6.0));
        enlazada.add(new Alumno("Luci", 4.0));
        enlazada.add(new Alumno("Zeus", 2.0));
        enlazada.add( new Alumno("Lucas", 2.0));
        System.out.println(enlazada + " Size = " + enlazada.size());
        System.out.println("Esta vacia = " + enlazada.isEmpty());
        System.out.println(enlazada);

        System.out.println(enlazada + ", size = " + enlazada.size());

        enlazada.addFirst(new Alumno("Kratos", 5.0));
        enlazada.addLast(new Alumno("Atenas", 6.0));
        System.out.println(enlazada + ", size = " + enlazada.size());

        System.out.println("Primero: " + enlazada.getFirst());
        System.out.println("Ultimo: " + enlazada.getLast());
//        System.out.println("Primero: " + enlazada.peekFirst());
//        System.out.println("Ultimo: " + enlazada.peekLast());
        System.out.println("Con el indice 2 = " + enlazada.get(2));

//        Alumno first = enlazada.pop();
//        Alumno first = enlazada.poll();
//        Alumno first = enlazada.pollFirst();
//        Alumno last = enlazada.pollLast();
        Alumno first = enlazada.removeFirst();
        Alumno last = enlazada.removeLast();
        System.out.println(enlazada + ", size = " + enlazada.size());

        enlazada.remove(new Alumno("Jano", 7.0));
        System.out.println(enlazada + ", size = " + enlazada.size());

        Alumno a = new Alumno("Lucas", 5.0);
        enlazada.addLast(a);
        System.out.println("El indice de lucas es: " + enlazada.indexOf(a));

        enlazada.remove(4);
        System.out.println(enlazada + ", size = " + enlazada.size());

        ListIterator<Alumno> li = enlazada.listIterator();

        while(li.hasNext()){
            Alumno alumno = li.next();
            System.out.println(alumno);
        }

        System.out.println("============== Previos =================");
        while (li.hasPrevious()){
            Alumno alumno = li.previous();
            System.out.println(alumno);
        }
    }
}
