package com.alabelewe.learningmanagementsystem.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;


@Repository
public class UserDaoImpl implements UserDAO{

    private EntityManager entityManager;

    @Autowired
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
