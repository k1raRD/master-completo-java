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
        return em.createQuery("SELECT c FROM Curso c left join fetch c.instructor", Curso.class).getResultList();
    }

    @Override
    public Curso guardar(Curso curso) {
        if(curso.getId() != null && curso.getId() > 0){
            em.merge(curso);
        }else{
            em.persist(curso);
        }
        return curso;
    }

    @Override
    public Curso porId(Long id) {
        return em.createQuery("SELECT c FROM Curso c left join fetch c.instructor WHERE c.id = :id", Curso.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public void eliminar(Long id) {
        em.remove(porId(id));
    }
}
