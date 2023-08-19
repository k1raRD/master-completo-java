package com.k1rard.apiservlet.webapp.headers.services;

import com.k1rard.apiservlet.webapp.headers.config.Service;
import com.k1rard.apiservlet.webapp.headers.models.entities.Usuario;
import com.k1rard.apiservlet.webapp.headers.repositories.RepositoryJpa;
import com.k1rard.apiservlet.webapp.headers.repositories.UsuarioRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.sql.SQLException;
import java.util.Optional;

@Service
@Stateless
public class UsuarioServiceImpl implements UsuarioService {
    private UsuarioRepository usuarioRepository;
    @Inject
    public UsuarioServiceImpl(@RepositoryJpa UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Optional<Usuario> login(String username, String password) {
        try {
            return Optional.ofNullable(usuarioRepository.porUsername(username)).filter(u -> u.getPassword().equals(password));
        } catch (Exception e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    public void crearUsuario(Usuario usuario){
        try {
            usuarioRepository.guardar(usuario);
        } catch (Exception e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }
}
