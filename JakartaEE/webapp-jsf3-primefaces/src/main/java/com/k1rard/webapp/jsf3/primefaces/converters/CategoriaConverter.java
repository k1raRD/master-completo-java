package com.k1rard.webapp.jsf3.primefaces.converters;

import com.k1rard.webapp.jsf3.primefaces.entities.Categoria;
import com.k1rard.webapp.jsf3.primefaces.services.ProductoService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.Optional;

@RequestScoped
@Named("categoriaConverter")
public class CategoriaConverter implements Converter<Categoria> {
    @Inject
    private ProductoService service;

    @Override
    public Categoria getAsObject(FacesContext context, UIComponent component, String id) {
        if(id == null){
            return null;
        }
        Optional<Categoria> categoriaOptional = service.porIdCategoria(Long.valueOf(id));
        if(categoriaOptional.isPresent()){
            return categoriaOptional.get();
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Categoria categoria) {
        if(categoria == null){
            return "0";
        }
        return categoria.getId().toString();
    }
}
