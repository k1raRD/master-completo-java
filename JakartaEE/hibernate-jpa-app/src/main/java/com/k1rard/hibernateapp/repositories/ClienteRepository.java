package com.k1rard.hibernateapp.repositories;

import com.k1rard.hibernateapp.entities.Cliente;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ClienteRepository implements CrudRepository<Cliente>{
    private EntityManager em;

    public ClienteRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Cliente> listar() {
        return em.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
    }

    @Override
    public Cliente porId(Long id) {
        return em.find(Cliente.class, id);
    }

    @Override
    public void guardar(Cliente cliente) {
        if(cliente.getId() != null && cliente.getId() > 0){
            em.merge(cliente);
        }else{
            em.persist(cliente);
        }
    }

    @Override
    public void eliminar(Long id) {
        Cliente c = porId(id);
        em.remove(c);
    }
}
