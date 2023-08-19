package com.k1rard.webapp.jsf3.primefaces.controllers;

import com.k1rard.webapp.jsf3.primefaces.entities.Categoria;
import com.k1rard.webapp.jsf3.primefaces.entities.Producto;
import com.k1rard.webapp.jsf3.primefaces.services.ProductoService;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Model;
import jakarta.enterprise.inject.Produces;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;
import java.util.ResourceBundle;

@Model
public class ProductoController {
    private Producto producto;
    private Long id;
    private List<Producto> listado;
    private String textoBuscar;
    @Inject
    private ProductoService service;
    @Inject
    private FacesContext facesContext;
    @Inject
    private ResourceBundle bundle;

    @PostConstruct
    public void init(){
        this.listado = service.listar();
    }

    @Produces
    @Model
    public String titulo() {
//        return "Hola Mundo Jakarta Server Faces 3.0";
        return bundle.getString("producto.texto.titulo");
    }

//    @Produces
//    @RequestScoped
//    @Named("listado")
//    public List<Producto> findAll() {
////        return Arrays.asList(new Producto("peras"), new Producto("manzanas"), new Producto("mandarinas"));
//        return service.listar();
//    }

    @Produces
    @Model
    public Producto producto() {
        this.producto = new Producto();
        if (id != null && id > 0) {
            service.porId(id).ifPresent(p -> {
                this.producto = p;
            });
        }
        return this.producto;
    }

    @Produces
    @Model
    public List<Categoria> categorias(){
        return service.listarCategorias();
    }

    public String guardar() {
        System.out.println(producto);
        if(producto.getId() != null && producto.getId() > 0){
            facesContext.addMessage(null, new FacesMessage(String.format(bundle.getString("producto.mensaje.editar"), producto.getNombre())));
        }else{
            facesContext.addMessage(null, new FacesMessage(String.format(bundle.getString("producto.mensaje.crear"), producto.getNombre())));
        }
        service.guardar(producto);
        listado = service.listar();
        return "index.xhtml";
    }

    public String editar(Long id) {
        this.id = id;
        return "form.xhtml";
    }

    public void eliminar(Producto producto) {
        service.eliminar(producto.getId());
        facesContext.addMessage(null, new FacesMessage(String.format(bundle.getString("producto.mensaje.eliminar"), producto.getNombre())));
        listado = service.listar();
    }

    public void buscar(){
        this.listado = service.buscarPorNombre(this.textoBuscar);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Producto> getListado() {
        return listado;
    }

    public void setListado(List<Producto> listado) {
        this.listado = listado;
    }

    public String getTextoBuscar() {
        return textoBuscar;
    }

    public void setTextoBuscar(String textoBuscar) {
        this.textoBuscar = textoBuscar;
    }
}
