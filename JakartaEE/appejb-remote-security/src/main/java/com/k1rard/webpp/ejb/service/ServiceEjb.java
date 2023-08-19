package com.k1rard.webpp.ejb.service;

import com.k1rard.webpp.ejb.models.Producto;
import jakarta.ejb.Stateful;
import jakarta.ejb.Stateless;

import java.util.ArrayList;
import java.util.List;

@Stateful
public class ServiceEjb implements ServiceEjbRemote {

    private int contador;
    public String saludar(String nombre){
        System.out.println("Imprimiendo dentro del ejb con instancia: " + this);
        contador++;
        System.out.println("El valor del contador en el metodo saludar " + contador);
        return "Hola que tal " + nombre;
    }

    @Override
    public List<Producto> listar() {
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto("peras"));
        productos.add(new Producto("manzanas"));
        productos.add(new Producto("naranjas"));
        return productos;
    }

    @Override
    public Producto crear(Producto producto) {
        System.out.println("Guardando el producto.... " + producto);
        Producto p = new Producto();
        p.setNombre(producto.getNombre());
        return p;
    }
}
