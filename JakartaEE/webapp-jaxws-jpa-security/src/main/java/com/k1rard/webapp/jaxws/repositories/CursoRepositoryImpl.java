package com.k1rard.webapp.jaxws.repositories;

import com.k1rard.webapp.jaxws.models.Curso;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;

@RequestScoped
public class CursoRepositoryImpl implements CursoRepository{
    @Inject
    private EntityManager em;
    @Override
    public List<Curso> listar() {
        return em.createQuery("FROM Curso", Curso.class).getResultList();
    }

    @Override
    public Curso guardar(Curso curso) {
        em.persist(curso);
        return curso;
    }
}
