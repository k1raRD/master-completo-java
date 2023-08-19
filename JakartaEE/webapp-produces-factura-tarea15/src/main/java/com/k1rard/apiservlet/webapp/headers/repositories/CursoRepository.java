package com.k1rard.apiservlet.webapp.headers.repositories;

import com.k1rard.apiservlet.webapp.headers.models.Curso;

import java.sql.SQLException;
import java.util.List;

public interface CursoRepository extends CrudRepository<Curso> {
    List<Curso> buscarPorNombre(String nombre) throws SQLException;
}
