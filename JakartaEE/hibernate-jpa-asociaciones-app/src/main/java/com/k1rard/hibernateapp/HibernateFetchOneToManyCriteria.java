package com.k1rard.hibernateapp;

import com.k1rard.hibernateapp.entities.Cliente;
import com.k1rard.hibernateapp.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class HibernateFetchOneToManyCriteria {
    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Cliente> query = cb.createQuery(Cliente.class);
        Root<Cliente> cliente = query.from(Cliente.class);

        cliente.fetch("direcciones", JoinType.LEFT);
        cliente.fetch("detalle", JoinType.LEFT);
        query.select(cliente).distinct(true);
        List<Cliente>clientes = em.createQuery(query).getResultList();
        clientes.forEach(c -> System.out.println(c.getNombre() + ", direcciones " + c.getDirecciones() + ", detalle " + c.getDetalle()));
        em.close();
    }
}
