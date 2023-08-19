package com.k1rard.hibernateapp;

import com.k1rard.hibernateapp.entities.Cliente;
import com.k1rard.hibernateapp.entities.Factura;
import com.k1rard.hibernateapp.util.JpaUtil;
import jakarta.persistence.EntityManager;

public class HibernateAsociacionesOneToManyBidireccional {
    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();

        try{
            em.getTransaction().begin();
            Cliente cliente = new Cliente("Cata", "Edu");
            cliente.setFormaPago("paypal");
            Factura f1 = new Factura("compras de supermercado", 5000L);
            Factura f2 = new Factura("compras de tecnologia", 7000L);
            cliente.addFactura(f1).addFactura(f2);
            em.persist(cliente);
            em.getTransaction().commit();
            System.out.println(cliente);

            em.getTransaction().begin();
//            Factura f3 = em.find(Factura.class, 1L);
            Factura f3 = new Factura("compras de supermercado", 5000L);
            f3.setId(1L);
            cliente.removeFactura(f3);
            em.getTransaction().commit();
            System.out.println(cliente);
        }catch (Exception ex){
            em.getTransaction().rollback();
            ex.printStackTrace();
        }finally {
            em.close();
        }
    }
}
