package com.k1rard.patrones.factory;

import com.k1rard.patrones.factory.producto.PizzaNewYorkItaliana;
import com.k1rard.patrones.factory.producto.PizzaNewYorkVegetariana;
import com.k1rard.patrones.factory.producto.PizzaNuevaYorkPepperoni;

public class PizzeriaNewYorkFactory extends PizzeriaZonaAbstractFactory{

    @Override
    PizzaProducto crearPizza(String tipo) {
        PizzaProducto producto = null;
        switch (tipo) {
            case "vegetariana" -> producto = new PizzaNewYorkVegetariana();
            case "pepperoni" -> producto = new PizzaNuevaYorkPepperoni();
            case "italiana" -> producto = new PizzaNewYorkItaliana();
            default -> System.out.println("La pizza seleccionada no esta disponible");
        }
        return producto;
    }
}
