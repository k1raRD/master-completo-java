package com.k1rard.webapp.ear.services;

import com.k1rard.webapp.ear.entities.Usuario;
import com.k1rard.webapp.ear.repositories.UsuarioRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;

@Stateless
public class UsuarioServiceImpl implements UsuarioService{
    @Inject
    private UsuarioRepository repository;
    @Override
    public List<Usuario> listar() {
        return repository.listar();
    }
}
