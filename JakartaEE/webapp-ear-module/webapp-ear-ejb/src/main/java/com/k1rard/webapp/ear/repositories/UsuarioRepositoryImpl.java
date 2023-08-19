package com.k1rard.webapp.ear.repositories;

import com.k1rard.webapp.ear.entities.Usuario;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;

    @RequestScoped
public class UsuarioRepositoryImpl implements UsuarioRepository{
    @Inject
    private EntityManager em;
    @Override
    public List<Usuario> listar() {
        return em.createQuery("FROM Usuario", Usuario.class).getResultList();
    }
}
