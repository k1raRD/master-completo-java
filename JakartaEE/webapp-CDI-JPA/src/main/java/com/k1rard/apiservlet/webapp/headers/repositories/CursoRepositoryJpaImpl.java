package com.k1rard.apiservlet.webapp.headers.repositories;

import com.k1rard.apiservlet.webapp.headers.config.Repository;
import com.k1rard.apiservlet.webapp.headers.models.entities.Curso;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.sql.SQLException;
import java.util.List;

@Repository
@RepositoryJpa
public class CursoRepositoryJpaImpl implements CursoRepository{
    @Inject
    private EntityManager em;

    @Override
    public List<Curso> listar() throws Exception {
        return em.createQuery("FROM Curso", Curso.class).getResultList();
    }

    @Override
    public Curso porId(Long id) throws Exception {
        return em.find(Curso.class, id);
    }

    @Override
    public void guardar(Curso curso) throws Exception {
        if(curso.getId() != null && curso.getId() > 0){
            em.merge(curso);
        }else{
            em.persist(curso);
        }
    }

    @Override
    public void eliminar(Long id) throws Exception {
        em.remove(porId(id));
    }

    @Override
    public List<Curso> buscarPorNombre(String nombre) throws SQLException {
        return em.createQuery("SELECT c FROM Curso c WHERE c.nombre = :nombre", Curso.class)
                .setParameter("nombre", nombre)
                .getResultList();
    }
}
