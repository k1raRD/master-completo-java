package com.k1rard.hibernateapp;

import com.k1rard.hibernateapp.entities.Cliente;
import com.k1rard.hibernateapp.entities.Factura;
import com.k1rard.hibernateapp.util.JpaUtil;
import jakarta.persistence.EntityManager;

public class HibernateAsociacionesManyToOneFind {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();

        try{
            em.getTransaction().begin();
            Cliente cliente = em.find(Cliente.class, 1L);
            Factura factura = new Factura("Compras de oficina", 1000L);
            factura.setCliente(cliente);
            em.persist(factura);
            System.out.println(factura);
            em.getTransaction().commit();
        }catch (Exception ex){
            em.getTransaction().rollback();
            ex.printStackTrace();
        } finally {

          em.close();
        }
    }
}
