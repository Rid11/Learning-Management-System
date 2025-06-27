package com.alabelewe.learningmanagementsystem.dao;

import com.alabelewe.learningmanagementsystem.entity.Role;

public interface RoleDAO {

    public Role findRoleByName(String name);
}
