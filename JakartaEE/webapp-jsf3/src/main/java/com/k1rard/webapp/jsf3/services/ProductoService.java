package com.k1rard.webapp.jsf3.services;

import com.k1rard.webapp.jsf3.entities.Categoria;
import com.k1rard.webapp.jsf3.entities.Producto;
import jakarta.ejb.Local;

import java.util.List;
import java.util.Optional;

@Local
public interface ProductoService {

    List<Producto> listar();
    Optional<Producto> porId(Long id);
    void guardar(Producto producto);
    void eliminar(Long id);
    List<Categoria> listarCategorias();
    Optional<Categoria> porIdCategoria(Long id);
}
