package com.k1rad.spring.backend.apirest.app.models.services;

import java.util.List;

import com.k1rad.spring.backend.apirest.app.models.entities.Cliente;

public interface IClienteService {
	
	List<Cliente> findAll();
	
	Cliente findById(Long id);
	
	Cliente save(Cliente cliente);
	
	void delete(Long id);
	
}
