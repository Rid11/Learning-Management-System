package com.alabelewe.learningmanagementsystem.dao;

import com.alabelewe.learningmanagementsystem.entity.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class RoleDaoImpl implements RoleDAO {


    private EntityManager entityManager;

    public RoleDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Role findRoleByName(String name){

        TypedQuery<Role> query = entityManager.createQuery("from Role where name=:name", Role.class);
        query.setParameter("name", name);

        Role theRole = null;
        try {
            theRole = query.getSingleResult();
        }catch (Exception e){
            theRole = null;
        }

        return theRole;
    }


}
