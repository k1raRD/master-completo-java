package com.k1rad.spring.backend.apirest.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.k1rad.spring.backend.apirest.app.models.entities.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Long>{

}
