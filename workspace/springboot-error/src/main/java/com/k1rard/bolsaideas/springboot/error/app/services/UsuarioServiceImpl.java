package com.k1rard.bolsaideas.springboot.error.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.k1rard.bolsaideas.springboot.error.app.models.domain.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	private List<Usuario> lista;

	
	public UsuarioServiceImpl() {
		this.lista = new ArrayList<Usuario>();
		this.lista.add(new Usuario(1, "Alex", "Collado"));
		this.lista.add(new Usuario(2, "Andres", "Guzman"));
		this.lista.add(new Usuario(3, "Pepe", "Martinez"));
		this.lista.add(new Usuario(4, "Carlos", "Gomez"));
		this.lista.add(new Usuario(5, "Mario", "Bros"));
		this.lista.add(new Usuario(6, "Julieta", "rodriguez"));
		this.lista.add(new Usuario(7, "jose", "Garcia"));
		
	}

	@Override
	public List<Usuario> listar() {	
		return lista;
	}

	@Override
	public Usuario buscarPorId(Integer id) {
		Usuario resultado = null;
		for(Usuario user: lista) {
			if(user.getId().equals(id)) {
				resultado = user;
				break;
			}
		}
		return resultado;
	}

	@Override
	public Optional<Usuario> buscarPorIdOptional(Integer id) {
		Usuario usuario = this.buscarPorId(id);
		return Optional.ofNullable(usuario);
	}

}
