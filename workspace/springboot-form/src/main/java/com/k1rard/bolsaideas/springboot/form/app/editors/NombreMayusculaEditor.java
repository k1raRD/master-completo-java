package com.k1rard.bolsaideas.springboot.form.app.editors;

import java.beans.PropertyEditorSupport;

public class NombreMayusculaEditor extends PropertyEditorSupport{

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
	
		setValue(text.toUpperCase().trim());
	}

	
}
