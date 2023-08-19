package com.k1rard.bolsaideas.springbootr.app.models.service;

import java.util.List;

import com.k1rard.bolsaideas.springbootr.app.models.entities.Cliente;

public interface IClienteService {

	List<Cliente> findAll();
	
	void save(Cliente cliente);
	
	Cliente findOne(Long id);
	
	void delete(Long id);
}
