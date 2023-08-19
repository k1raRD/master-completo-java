package com.k1rard.hibernateapp;

import com.k1rard.hibernateapp.entities.Cliente;
import com.k1rard.hibernateapp.util.JpaUtil;
import jakarta.persistence.EntityManager;

import javax.swing.*;

public class HibernateCrear {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();

        try{
            String nombre = JOptionPane.showInputDialog("Introduzca el nombre");
            String apellido = JOptionPane.showInputDialog("Ingrese el apellido");
            String pago = JOptionPane.showInputDialog("Ingrese la forma de pago");
            Cliente c = new Cliente();
            c.setNombre(nombre);
            c.setApellido(apellido);
            c.setFormaPago(pago);
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
            System.out.println("El Id del cliente registrado es: " + c.getId());
            c = em.find(Cliente.class, c.getId());
            System.out.println(c);
        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }
    }
}
