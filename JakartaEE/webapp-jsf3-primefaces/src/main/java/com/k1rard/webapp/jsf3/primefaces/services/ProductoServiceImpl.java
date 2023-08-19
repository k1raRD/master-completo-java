package com.k1rard.webapp.jsf3.primefaces.services;

import com.k1rard.webapp.jsf3.primefaces.entities.Categoria;
import com.k1rard.webapp.jsf3.primefaces.entities.Producto;
import com.k1rard.webapp.jsf3.primefaces.repositories.CrudRepository;
import com.k1rard.webapp.jsf3.primefaces.repositories.ProductoRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@Stateless
public class ProductoServiceImpl implements ProductoService {
    @Inject
    ProductoRepository repository;

    @Inject
    CrudRepository<Categoria> categoriaRepository;

    @Override
    public List<Producto> listar() {
        return repository.listar();
    }

    @Override
    public Optional<Producto> porId(Long id) {
        return Optional.ofNullable(repository.porId(id));
    }

    @Override
    public void guardar(Producto producto) {
        repository.guardar(producto);
    }

    @Override
    public void eliminar(Long id) {
        repository.eliminar(id);
    }

    @Override
    public List<Categoria> listarCategorias() {
        return categoriaRepository.listar();
    }

    @Override
    public Optional<Categoria> porIdCategoria(Long id) {
        return Optional.ofNullable(categoriaRepository.porId(id));
    }

    @Override
    public List<Producto> buscarPorNombre(String nombre) {
        return repository.buscarPorNombre(nombre);
    }
}
