package com.k1rard.webapp.jsf3.primefaces.repositories;

import com.k1rard.webapp.jsf3.primefaces.entities.Producto;

import java.util.List;

public interface ProductoRepository extends CrudRepository<Producto>{
    List<Producto> buscarPorNombre(String nombre);
}
