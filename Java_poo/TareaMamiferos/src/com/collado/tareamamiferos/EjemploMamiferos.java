package com.collado.tareamamiferos;

import com.collado.tareamamiferos.domain.Mamifero;
import com.collado.tareamamiferos.domain.caninos.Lobo;
import com.collado.tareamamiferos.domain.caninos.Perro;
import com.collado.tareamamiferos.domain.felinos.Guepardo;
import com.collado.tareamamiferos.domain.felinos.Leon;
import com.collado.tareamamiferos.domain.felinos.Tigre;

public class EjemploMamiferos {
    public static void main(String[] args) {
        Lobo lobo = new Lobo("montanas", 3.2f, 5.6f, 8.3f, "lobezno", "blanco", 3f, 10, "wolverine");
        Perro perro = new Perro("Casa", 3.4f, 2.4f, 6.3f, "ladridor", "negro", 2f, 3);
        Guepardo guepardo = new Guepardo("Selva", 4.5f, 2.3f, 4.5f, "guepardi",  3.4f, 23);
        Leon leon = new Leon("Selva", 3.4f, 4.3f, 4.3f, "leonardi", 4.3f, 1,4, 10);
        Tigre tigre = new Tigre("Selva", 3.4f, 3.5f, 5.4f, "tigresi", 4.5f, 3, "tigroni");
        Mamifero[] mamiferos = {lobo,perro,guepardo,leon,tigre};

        for(Mamifero m: mamiferos){
            System.out.println("");
            System.out.println(m);
        }

    }
}
