package com.k1rard.webapp.jsf3.repositories;

import com.k1rard.webapp.jsf3.entities.Producto;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;
@RequestScoped
public class ProductoRepositoryImpl implements CrudRepository<Producto>{
    @Inject
    private EntityManager em;
    @Override
    public List<Producto> listar() {
        return em.createQuery("SELECT p FROM Producto p left join fetch p.categoria", Producto.class).getResultList();
    }

    @Override
    public Producto porId(Long id) {
        return em.createQuery("SELECT p FROM Producto p left join fetch p.categoria where p.id = :id", Producto.class)
                .setParameter("id", id)
                .getSingleResult();
//        return em.find(Producto.class, id);
    }

    @Override
    public void guardar(Producto producto) {
        if(producto.getId() != null && producto.getId() > 0){
            em.merge(producto);
        }else{
            em.persist(producto);
        }
    }

    @Override
    public void eliminar(Long id) {
        em.remove(porId(id));
    }
}
