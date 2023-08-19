package com.k1rard.apiservlet.webapp.headers.services;

import com.k1rard.apiservlet.webapp.headers.models.entities.Categoria;
import com.k1rard.apiservlet.webapp.headers.models.entities.Producto;
import jakarta.enterprise.inject.Alternative;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Alternative
public class ProductoServiceListImpl implements ProductosService{
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

    @Override
    public Optional<Producto> buscarPorId(Long id) {
        return listar().stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    @Override
    public void guardar(Producto producto) {

    }

    @Override
    public void eliminar(Long id) {

    }

    @Override
    public List<Categoria> listarCategoria() {
        return null;
    }

    @Override
    public Optional<Categoria> porIdCategoria(Long id) {
        return Optional.empty();
    }
}
