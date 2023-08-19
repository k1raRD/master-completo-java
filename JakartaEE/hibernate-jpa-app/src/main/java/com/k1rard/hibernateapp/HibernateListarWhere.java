package com.k1rard.hibernateapp;

import com.k1rard.hibernateapp.entities.Cliente;
import com.k1rard.hibernateapp.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;
import java.util.Scanner;

public class HibernateListarWhere {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        EntityManager em = JpaUtil.getEntityManager();
        Query query = em.createQuery("SELECT c FROM Cliente c WHERE c.formaPago = ?1", Cliente.class);
        System.out.println("Introduzca la forma de pago: ");
        String pago = s.next();
        query.setParameter(1, pago);
        List<Cliente> c = (List<Cliente>) query.getResultList();
        System.out.println(c);
        em.close();
    }
}
