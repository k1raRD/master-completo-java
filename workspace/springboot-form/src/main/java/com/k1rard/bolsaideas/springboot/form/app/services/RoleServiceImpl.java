package com.k1rard.bolsaideas.springboot.form.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.k1rard.bolsaideas.springboot.form.app.models.domain.Role;

@Service
public class RoleServiceImpl implements RoleService{

	private List<Role> roles;
	
	public RoleServiceImpl() {
		this.roles = new ArrayList<Role>();
		this.roles.add(new Role(1, "Administrador", "ROLE_ADMIN"));
		this.roles.add(new Role(2, "User", "ROLE_USER"));
		this.roles.add(new Role(1, "Moderador", "ROLE_MODERATOR"));
	}

	@Override
	public List<Role> listar() {
		return roles;
	}

	@Override
	public Role obtenerPorId(Integer id) {
		Optional<Role> roleOptional = roles.stream()
				.filter(r -> r.getId() == id)
				.findFirst();
		return roleOptional.orElse(null);
	}
	
}
