package com.k1rard.bolsaideas.springboot.form.app.services;

import java.util.List;

import com.k1rard.bolsaideas.springboot.form.app.models.domain.Role;

public interface RoleService {
	
	List<Role> listar();
	
	Role obtenerPorId(Integer id);
}
