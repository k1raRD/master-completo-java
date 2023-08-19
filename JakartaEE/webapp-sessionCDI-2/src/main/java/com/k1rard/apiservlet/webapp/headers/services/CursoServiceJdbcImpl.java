package com.k1rard.apiservlet.webapp.headers.services;

import com.k1rard.apiservlet.webapp.headers.config.Service;
import com.k1rard.apiservlet.webapp.headers.models.Curso;
import com.k1rard.apiservlet.webapp.headers.repositories.CursoRepository;
import com.k1rard.apiservlet.webapp.headers.repositories.CursoRepositoryJdbcImpl;
import jakarta.inject.Inject;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Service
public class CursoServiceJdbcImpl implements CursosService{

    @Inject
    private CursoRepository repository;

    @Override
    public List<Curso> listar() {
        try {
            return repository.listar();
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public List<Curso> buscarPorNombre(String nombre){
        try {
            return repository.buscarPorNombre(nombre);
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Curso buscarPorId(Long id) {
        try {
            return repository.porId(id);
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void guardar(Curso curso) {
        try {
            repository.guardar(curso);
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void eliminar(Long id) {
        try {
            repository.eliminar(id);
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }
}
