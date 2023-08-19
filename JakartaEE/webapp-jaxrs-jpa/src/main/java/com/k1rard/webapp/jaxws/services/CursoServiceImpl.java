package com.k1rard.webapp.jaxws.services;

import com.k1rard.webapp.jaxws.models.Curso;
import com.k1rard.webapp.jaxws.repositories.CursoRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.jws.WebMethod;

import java.util.List;
import java.util.Optional;

@Stateless
public class CursoServiceImpl implements CursoService {
    @Inject
    private CursoRepository repository;

    @Override
    @WebMethod
    public List<Curso> listar() {
        return repository.listar();
    }

    @Override
    @WebMethod
    public Curso guardar(Curso curso) {
        return repository.guardar(curso);
    }

    @Override
    public Optional<Curso> porId(Long id) {
        return Optional.ofNullable(repository.porId(id));
    }

    @Override
    public void eliminar(Long id) {
        repository.eliminar(id);
    }
}
