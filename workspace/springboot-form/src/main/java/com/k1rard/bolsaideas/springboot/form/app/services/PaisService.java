package com.k1rard.bolsaideas.springboot.form.app.services;

import java.util.List;

import com.k1rard.bolsaideas.springboot.form.app.models.domain.Pais;

public interface PaisService {
	
	List<Pais> listar();
	Pais obtenerPorId(Integer id);
}
