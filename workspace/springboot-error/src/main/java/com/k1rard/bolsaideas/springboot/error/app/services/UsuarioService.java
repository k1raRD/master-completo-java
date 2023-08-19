package com.k1rard.bolsaideas.springboot.error.app.services;

import java.util.List;
import java.util.Optional;

import com.k1rard.bolsaideas.springboot.error.app.models.domain.Usuario;

public interface UsuarioService {

	List<Usuario> listar();
	
	Usuario buscarPorId(Integer id);
	
	Optional<Usuario> buscarPorIdOptional(Integer id);
}
