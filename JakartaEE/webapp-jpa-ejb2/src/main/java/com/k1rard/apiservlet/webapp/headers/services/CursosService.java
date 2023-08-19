package com.k1rard.apiservlet.webapp.headers.services;

import com.k1rard.apiservlet.webapp.headers.models.entities.Curso;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface CursosService {
    List<Curso> listar();
    List<Curso> buscarPorNombre(String nombre);

    Curso buscarPorId(Long id);
    void guardar(Curso curso);
    void eliminar(Long id);
}
