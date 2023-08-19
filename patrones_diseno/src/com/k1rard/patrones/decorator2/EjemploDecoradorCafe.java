package com.k1rard.patrones.decorator2;

import com.k1rard.patrones.decorator2.decoradores.ConChocolateDecorador;
import com.k1rard.patrones.decorator2.decoradores.ConCremaDecorador;
import com.k1rard.patrones.decorator2.decoradores.ConLecheDecorador;

public class EjemploDecoradorCafe {
    public static void main(String[] args) {

        Configurable cafe = new Cafe("Cafe Mocha", 7);
        ConCremaDecorador  conCrema = new ConCremaDecorador(cafe);
        ConLecheDecorador conLeche = new ConLecheDecorador(conCrema);
        ConChocolateDecorador conChocolate = new ConChocolateDecorador(conLeche);

        System.out.println("El precio de cafe mocha es: " + conChocolate.getPrecioBase());
        System.out.println("Los ingredientes: " + conChocolate.getIngredientes());

        Configurable capuchino = new Cafe("Cafe capuchino", 4);
        conCrema = new ConCremaDecorador(capuchino);
        conLeche = new ConLecheDecorador(capuchino);
        System.out.println("El precio del capuchino es: " + conLeche.getPrecioBase());
        System.out.println("Los ingredientes del capuchino es: " + conLeche.getIngredientes());

        Configurable cafeExpreso = new Cafe("Cafe expresso", 3);
        System.out.println("El precio el cafe expresso es: " + cafeExpreso.getPrecioBase());
        System.out.println("Los ingredientes del cafe expresso es: " + cafeExpreso.getIngredientes());
    }
}
