package com.k1rard.hibernateapp;

import com.k1rard.hibernateapp.entities.Cliente;
import com.k1rard.hibernateapp.entities.ClienteDetalle;
import com.k1rard.hibernateapp.util.JpaUtil;
import jakarta.persistence.EntityManager;

public class HibernateAsociacionesOnetoOneFind {
    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();
        try{
            em.getTransaction().begin();

            Cliente cliente = em.find(Cliente.class, 2L);
            ClienteDetalle clienteDetalle = new ClienteDetalle(true, 5000L);
            em.persist(clienteDetalle);

            cliente.setDetalle(clienteDetalle);
            em.getTransaction().commit();
            System.out.println(cliente);
        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace(System.out);
        }finally {
            em.close();
        }


    }
}
