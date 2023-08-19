package com.k1rard.bolsaideas.springbootr.app.models.dao;


import org.springframework.data.repository.CrudRepository;

import com.k1rard.bolsaideas.springbootr.app.models.entities.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Long>{

}
