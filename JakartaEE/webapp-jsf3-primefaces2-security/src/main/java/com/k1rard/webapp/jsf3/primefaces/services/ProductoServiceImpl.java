package com.k1rard.webapp.jsf3.primefaces.services;

import com.k1rard.webapp.jsf3.primefaces.entities.Categoria;
import com.k1rard.webapp.jsf3.primefaces.entities.Producto;
import com.k1rard.webapp.jsf3.primefaces.repositories.CrudRepository;
import com.k1rard.webapp.jsf3.primefaces.repositories.ProductoRepository;
import jakarta.annotation.Resource;
import jakarta.annotation.security.DeclareRoles;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ejb.SessionContext;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.jws.soap.SOAPBinding;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Stateless
@DeclareRoles({"USER", "ADMIN"})
public class ProductoServiceImpl implements ProductoService {
    @Inject
    ProductoRepository repository;

    @Inject
    CrudRepository<Categoria> categoriaRepository;

    @Resource
    private SessionContext ctx;

    @Override
    @PermitAll
    public List<Producto> listar() {
        Principal usuario = ctx.getCallerPrincipal();
        String username = usuario.getName();
        System.out.println("Username: " + username);
        if(ctx.isCallerInRole("ADMIN")){
            System.out.println("Hola soy un Administrador!");
        }else if(ctx.isCallerInRole("USER")){
            System.out.println("Hola soy un usuario normal!");
        }else{
            System.out.println("Hola soy un usuario anónimo!");
//            throw new SecurityException("Lo sentimos no tienes permisos para acceder a esta pagina");
        }
        return repository.listar();
    }

    @Override
    @RolesAllowed({"USER", "ADMIN"})
    public Optional<Producto> porId(Long id) {
        return Optional.ofNullable(repository.porId(id));
    }

    @Override
    @RolesAllowed("ADMIN")
    public void guardar(Producto producto) {
        repository.guardar(producto);
    }

    @Override
    @RolesAllowed("ADMIN")
    public void eliminar(Long id) {
        repository.eliminar(id);
    }

    @Override
    @RolesAllowed({"USER","ADMIN"})
    public List<Categoria> listarCategorias() {
        return categoriaRepository.listar();
    }

    @Override
    @RolesAllowed({"USER","ADMIN"})
    public Optional<Categoria> porIdCategoria(Long id) {
        return Optional.ofNullable(categoriaRepository.porId(id));
    }

    @Override
    @RolesAllowed({"USER","ADMIN"})
    public List<Producto> buscarPorNombre(String nombre) {
        return repository.buscarPorNombre(nombre);
    }
}
