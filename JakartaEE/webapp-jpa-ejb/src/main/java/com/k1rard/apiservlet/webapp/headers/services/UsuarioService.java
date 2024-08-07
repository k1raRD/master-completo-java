package com.k1rard.apiservlet.webapp.headers.services;

import com.k1rard.apiservlet.webapp.headers.models.entities.Usuario;
import jakarta.ejb.Local;

import java.util.Optional;

@Local
public interface UsuarioService {
    Optional<Usuario> login(String username, String password);

    void crearUsuario(Usuario usuario);
}
