package com.gregoriopalama.examples.ogmwildfly.repository;

import com.gregoriopalama.examples.ogmwildfly.dao.User;
import org.hibernate.ogm.OgmSession;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * Created by gregorio on 24/08/16.
 */
@Stateless
@LocalBean
public class UserRepositoryBean implements UserRepositoryBeanLocal {

    @Inject
    EntityManager entityManager;

    @Override
    public User insert(User user) {
        entityManager.persist(user);

        return user;
    }

    @Override
    public User findByUsername(String username) {
        OgmSession ogmSession = entityManager.unwrap(OgmSession.class);

        User user = (User) ogmSession
                .createQuery("FROM User WHERE username = :username")
                .setParameter("username", username).uniqueResult();

        return user;
    }

}