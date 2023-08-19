package com.k1rard.apiservlet.webapp.headers.services;

import com.k1rard.apiservlet.webapp.headers.models.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductosService {
    List<Producto> listar();
    public Optional<Producto> buscarPorNombre(String nombre);
}
