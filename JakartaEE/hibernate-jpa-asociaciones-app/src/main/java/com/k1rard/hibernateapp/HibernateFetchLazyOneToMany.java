package com.k1rard.hibernateapp;

import com.k1rard.hibernateapp.entities.Cliente;
import com.k1rard.hibernateapp.util.JpaUtil;
import jakarta.persistence.EntityManager;

public class HibernateFetchLazyOneToMany {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        Cliente cliente = em.find(Cliente.class, 1L);
        System.out.println();
        em.close();
    }
}
