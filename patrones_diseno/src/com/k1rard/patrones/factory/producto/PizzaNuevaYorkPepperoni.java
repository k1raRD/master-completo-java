package com.k1rard.patrones.factory.producto;

import com.k1rard.patrones.factory.PizzaProducto;

public class PizzaNuevaYorkPepperoni extends PizzaProducto {
    public PizzaNuevaYorkPepperoni() {
        super();
        nombre = "Piza de Pepperoni de New York";
        masa = "Masa delgada a la piedra";
        salsa = "Salsa de tomate";
        ingredientes.add("Queso mozzarella");
        ingredientes.add("Extra pepperoni");
        ingredientes.add("Aceitunas");
    }

    @Override
    public void cocinar() {
        System.out.println("Cocinando por 40min. a 90'C");
    }

    @Override
    public void cortar() {
        System.out.println("Cortando la pizza en triangulos.");
    }
}
