package com.k1rard.webapp.jaxws;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@RequestScoped
public class ProducerEntirtyManager {
    @PersistenceContext(name = "ejemploJPA")
    private EntityManager em;

    @Produces
    @RequestScoped
    private EntityManager beanEnityManager(){
        return em;
    }
}
