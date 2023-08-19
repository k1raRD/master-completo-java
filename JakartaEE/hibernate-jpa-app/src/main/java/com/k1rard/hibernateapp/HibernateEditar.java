package com.k1rard.hibernateapp;

import com.k1rard.hibernateapp.entities.Cliente;
import com.k1rard.hibernateapp.util.JpaUtil;
import jakarta.persistence.EntityManager;

import javax.swing.*;

public class HibernateEditar {
    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();
        try{
            Long id  = Long.valueOf(JOptionPane.showInputDialog("Ingrese el id del cliente que desea modificar: "));
            Cliente c = em.find(Cliente.class, id);

            String nombre = JOptionPane.showInputDialog("Ingrese el nombre: " , c.getNombre());
            String apellido = JOptionPane.showInputDialog("Ingrese el apellido: " , c.getApellido());
            String pago = JOptionPane.showInputDialog("Ingrese la forma de pago: " , c.getFormaPago());
            em.getTransaction().begin();
            c.setNombre(nombre);
            c.setApellido(apellido);
            c.setFormaPago(pago);
            em.merge(c);
            em.getTransaction().commit();
            System.out.println(c);
        }catch (Exception ex){
            em.getTransaction().rollback();
            ex.printStackTrace();
        }finally {
            em.close();
        }
    }
}
