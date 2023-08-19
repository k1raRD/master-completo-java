package com.k1rard.apiservlet.webapp.headers.repositories;

import com.k1rard.apiservlet.webapp.headers.models.entities.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario> {
    Usuario porUsername(String username) throws Exception;
}
