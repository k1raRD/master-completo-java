package com.k1rard.webapp.jaxws.services;

import com.k1rard.webapp.jaxws.models.Curso;
import com.k1rard.webapp.jaxws.repositories.CursoRepository;
import jakarta.annotation.security.DeclareRoles;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.jws.WebMethod;

import java.util.List;
import java.util.Optional;

@Stateless
@DeclareRoles({"ADMIN", "USER"})
public class CursoServiceImpl implements CursoService {
    @Inject
    private CursoRepository repository;

    @Override
    @RolesAllowed({"ADMIN", "USER"})
    public List<Curso> listar() {
        return repository.listar();
    }

    @Override
    @RolesAllowed("ADMIN")
    public Curso guardar(Curso curso) {
        return repository.guardar(curso);
    }

    @Override
    @RolesAllowed({"ADMIN", "USER"})
    public Optional<Curso> porId(Long id) {
        return Optional.ofNullable(repository.porId(id));
    }

    @Override
    @RolesAllowed("ADMIN")
    public void eliminar(Long id) {
        repository.eliminar(id);
    }
}
