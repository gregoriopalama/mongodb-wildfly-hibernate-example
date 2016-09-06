package com.gregoriopalama.examples.ogmwildfly.repository;

import com.gregoriopalama.examples.ogmwildfly.dao.User;

/**
 * Created by gregorio on 24/08/16.
 */
public interface UserRepositoryBeanLocal {
    public User insert(User user);
    public User findByUsername(String username);
}
