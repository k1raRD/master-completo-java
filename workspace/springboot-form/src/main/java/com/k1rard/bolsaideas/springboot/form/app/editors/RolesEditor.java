package com.k1rard.bolsaideas.springboot.form.app.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.k1rard.bolsaideas.springboot.form.app.services.RoleService;

@Component
public class RolesEditor extends PropertyEditorSupport{

	@Autowired
	private RoleService service;
	
	@Override
	public void setAsText(String idString) throws IllegalArgumentException {
		try {
			Integer id = Integer.parseInt(idString);
			setValue(service.obtenerPorId(id));
		}catch(NumberFormatException e) {
			setValue(null);
		}
		
	}

	
}
