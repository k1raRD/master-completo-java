package com.k1rard.apiservlet.webapp.headers.services;

import com.k1rard.apiservlet.webapp.headers.config.Service;
import com.k1rard.apiservlet.webapp.headers.models.entities.Curso;
import com.k1rard.apiservlet.webapp.headers.repositories.CursoRepository;
import com.k1rard.apiservlet.webapp.headers.repositories.RepositoryJpa;
import jakarta.ejb.Stateful;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.sql.SQLException;
import java.util.List;

@Service
@Stateful
public class CursoServiceJdbcImpl implements CursosService{

    @Inject
    @RepositoryJpa
    private CursoRepository repository;

    @Override
    public List<Curso> listar() {
        try {
            return repository.listar();
        } catch (Exception e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public List<Curso> buscarPorNombre(String nombre){
        try {
            return repository.buscarPorNombre(nombre);
        } catch (Exception e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Curso buscarPorId(Long id) {
        try {
            return repository.porId(id);
        } catch (Exception e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void guardar(Curso curso) {
        try {
            repository.guardar(curso);
        } catch (Exception e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void eliminar(Long id) {
        try {
            repository.eliminar(id);
        } catch (Exception e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }
}
