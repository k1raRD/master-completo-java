package com.k1rard.webapp.jaxws.services;

import com.k1rard.webapp.jaxws.models.Curso;
import com.k1rard.webapp.jaxws.repositories.CursoRepository;
import jakarta.annotation.security.DeclareRoles;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

import java.util.Arrays;
import java.util.List;

@DeclareRoles({"USER", "ADMIN"})
@Stateless
@WebService(endpointInterface = "com.k1rard.webapp.jaxws.services.CursoServicioWs")
public class CursoServiceWsImpl implements CursoServicioWs {
    @Inject
    private CursoRepository repository;

    @RolesAllowed({"ADMIN", "USER"})
    @Override
    @WebMethod
    public List<Curso> listar() {
        return repository.listar();
    }

    @RolesAllowed("ADMIN")
    @Override
    @WebMethod
    public Curso guardar(Curso curso) {
        return repository.guardar(curso);
    }
}
