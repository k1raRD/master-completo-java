package com.k1rard.apiservlet.webapp.headers.services;

import com.k1rard.apiservlet.webapp.headers.models.entities.Categoria;
import com.k1rard.apiservlet.webapp.headers.models.entities.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductosService {
    List<Producto> listar();
    Optional<Producto> buscarPorNombre(String nombre);
    Optional<Producto> buscarPorId(Long id);
    void guardar(Producto producto);
    void eliminar(Long id);
    List<Categoria> listarCategoria();
    Optional<Categoria> porIdCategoria(Long id);
}
