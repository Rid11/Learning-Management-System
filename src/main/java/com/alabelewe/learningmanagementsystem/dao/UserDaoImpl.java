package com.alabelewe.learningmanagementsystem.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.security.core.userdetails.User;

public class UserDaoImpl implements UserDAO{

    private EntityManager entityManager;

    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public User findUserByName(String userName) {
        TypedQuery<User> query = entityManager.createQuery("from User where username=:uName", User.class);

        query.setParameter("uName", userName);

        User theUser = null;
        try {
            theUser = query.getSingleResult();
        } catch (Exception e) {
            theUser = null;
        }

        return theUser;
    }
}
