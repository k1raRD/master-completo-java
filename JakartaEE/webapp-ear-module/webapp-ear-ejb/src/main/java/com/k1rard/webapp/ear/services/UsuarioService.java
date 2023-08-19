package com.k1rard.webapp.ear.services;

import com.k1rard.webapp.ear.entities.Usuario;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface UsuarioService {
    List<Usuario> listar();
}
