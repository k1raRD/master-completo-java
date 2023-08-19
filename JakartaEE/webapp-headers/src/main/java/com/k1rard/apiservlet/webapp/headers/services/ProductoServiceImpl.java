package com.k1rard.apiservlet.webapp.headers.services;

import com.k1rard.apiservlet.webapp.headers.models.Producto;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ProductoServiceImpl implements ProductosService{
    @Override
    public List<Producto> listar() {
        return Arrays.asList(new Producto(1L, "notebook", "computacion", 175000),
                new Producto(2L, "Mesa escritorio", "oficina", 100000),
                new Producto(3L, "Teclado mecanico", "computacion", 40000));
    }

    public Optional<Producto> buscarPorNombre(String nombre){
         return listar().stream().filter(p -> {
           if(nombre == null || nombre.isBlank()){
               return false;
           }
           return p.getNombre().contains(nombre);
         }).findFirst();
    }
}
