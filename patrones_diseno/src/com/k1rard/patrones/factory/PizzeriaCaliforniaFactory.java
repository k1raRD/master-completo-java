package com.k1rard.patrones.factory;

import com.k1rard.patrones.factory.producto.PizzaCaliforniaPepperoni;
import com.k1rard.patrones.factory.producto.PizzaCaliforniaQueso;
import com.k1rard.patrones.factory.producto.PizzaCaliforniaVegetariana;

public class PizzeriaCaliforniaFactory extends PizzeriaZonaAbstractFactory{

    @Override
    PizzaProducto crearPizza(String tipo) {
        PizzaProducto producto = null;
        switch (tipo){
            case "queso" -> producto = new PizzaCaliforniaQueso();
            case "pepperoni" -> producto = new PizzaCaliforniaPepperoni();
            case "vegetariana" -> producto = new PizzaCaliforniaVegetariana();
            default -> System.out.println("La pizza seleccionada no esta disponible");
        }
        return producto;
    }
}
