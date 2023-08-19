package com.k1rard.bolsaideas.springboot.di.app.models.domain;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@SessionScope
public class Factura implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7898644318045605801L;

	@Value("${factura.descripcion}")
	private String descripcion;
	
	@Autowired
	private Cliente cliente;
	
	@Autowired
	@Qualifier("default")
	private List<ItemFactura> items;
	
	@PostConstruct
	public void init() {
		cliente.setNombre(cliente.getNombre().concat(" ").concat("Jose"));
		descripcion = descripcion.concat(" del cliente: ").concat(cliente.getNombre());
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("Factura destruida: ".concat(descripcion));
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemFactura> getItems() {
		return items;
	}

	public void setItems(List<ItemFactura> items) {
		this.items = items;
	}

}