package com.k1rard.hibernateapp;

import com.k1rard.hibernateapp.entities.Cliente;
import com.k1rard.hibernateapp.util.JpaUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class HibernateFetchResultList {
    public static void main(String[] args) {
        EntityManager em  = JpaUtil.getEntityManager();

        List<Cliente> clientes = em.createQuery("SELECT distinct c FROM Cliente c left outer join fetch c.direcciones left outer join fetch c.detalle", Cliente.class).getResultList();
        clientes.forEach(System.out::println);
        em.close();
    }
}
