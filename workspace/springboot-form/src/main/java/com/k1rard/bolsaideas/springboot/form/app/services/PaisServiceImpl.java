package com.k1rard.bolsaideas.springboot.form.app.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.k1rard.bolsaideas.springboot.form.app.models.domain.Pais;

@Service
public class PaisServiceImpl implements PaisService{

	private List<Pais> lista;
	
	public PaisServiceImpl() {
		this.lista = Arrays.asList(
				new Pais(1, "ES","Espana"), 
				new Pais(2, "MX","Mexico"), 
				new Pais(3, "CL","Chile"),
				new Pais(4, "CO","Colombia"),
				new Pais(5, "PE","Peru"),
				new Pais(6, "VE","Venezuela"));
	}

	@Override
	public List<Pais> listar() {
		return lista;
	}

	@Override
	public Pais obtenerPorId(Integer id) {
		Optional<Pais> paisOptional = lista.stream()
				.filter(p -> p.getId() == id)
				.findFirst();
		
		return paisOptional.orElse(null);
	}

}
