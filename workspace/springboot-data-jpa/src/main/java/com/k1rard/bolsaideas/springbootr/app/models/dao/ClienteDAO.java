package com.k1rard.bolsaideas.springbootr.app.models.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.k1rard.bolsaideas.springbootr.app.models.entities.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
@Transactional
public class ClienteDAO {

	@PersistenceContext
	private EntityManager em;
	
	Cliente findById(Long id) {
		return em.find(Cliente.class, id);
	}
}
