package com.gregoriopalama.examples.ogmwildfly.provider;

import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by gregorio on 24/08/16.
 */
@Stateless
public class EntityManagerFactory {
    @PersistenceContext(unitName = "ExamplePU")
    private EntityManager entityManager;

    @Produces
    @RequestScoped
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
