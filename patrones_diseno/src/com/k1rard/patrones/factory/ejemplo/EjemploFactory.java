package com.k1rard.patrones.factory.ejemplo;

import com.k1rard.patrones.factory.PizzaProducto;
import com.k1rard.patrones.factory.PizzeriaCaliforniaFactory;
import com.k1rard.patrones.factory.PizzeriaNewYorkFactory;
import com.k1rard.patrones.factory.PizzeriaZonaAbstractFactory;

public class EjemploFactory {
    public static void main(String[] args) {
        PizzeriaZonaAbstractFactory ny = new PizzeriaNewYorkFactory();
        PizzeriaZonaAbstractFactory california = new PizzeriaCaliforniaFactory();

        PizzaProducto pizza = california.ordenarPizza("queso");
        System.out.println("Bruce ordena la pizza " + pizza.getNombre());

        pizza = ny.ordenarPizza("pepperoni");
        System.out.println("Andres ordena una " + pizza.getNombre());

        pizza = california.ordenarPizza("vegetariana");
        System.out.println("James ordena " + pizza.getNombre());

        pizza = ny.ordenarPizza("vegetariana");
        System.out.println("Linus ordena " +  pizza);

        pizza = california.ordenarPizza("pepperoni");
        System.out.println("Luis ordena " + pizza.getNombre());

        System.out.println("pizza = " + pizza);
    }
}
