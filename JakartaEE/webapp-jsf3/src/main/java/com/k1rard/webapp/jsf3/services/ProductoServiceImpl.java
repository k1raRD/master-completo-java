package com.k1rard.webapp.jsf3.services;

import com.k1rard.webapp.jsf3.entities.Categoria;
import com.k1rard.webapp.jsf3.entities.Producto;
import com.k1rard.webapp.jsf3.repositories.CategoriaRepositoryImpl;
import com.k1rard.webapp.jsf3.repositories.CrudRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@Stateless
public class ProductoServiceImpl implements ProductoService {
    @Inject
    CrudRepository<Producto> repository;

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
}
