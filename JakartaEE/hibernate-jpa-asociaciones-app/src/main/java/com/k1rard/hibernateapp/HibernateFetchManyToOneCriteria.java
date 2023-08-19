package com.k1rard.hibernateapp;

import com.k1rard.hibernateapp.entities.Cliente;
import com.k1rard.hibernateapp.entities.Factura;
import com.k1rard.hibernateapp.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;

import java.util.List;

public class HibernateFetchManyToOneCriteria {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Factura> query = cb.createQuery(Factura.class);
        Root<Factura> factura = query.from(Factura.class);
        Join<Factura, Cliente> cliente = (Join) factura.fetch("cliente", JoinType.LEFT);
        cliente.fetch("detalle", JoinType.LEFT);

        query.select(factura).where(cb.equal(cliente.get("id"), 1L));
        List<Factura> facturas = em.createQuery(query).getResultList();
        facturas.forEach(f -> System.out.println(f.getDescripcion() + ", cliente: " + f.getCliente().getNombre()));
        em.close();
    }
}
