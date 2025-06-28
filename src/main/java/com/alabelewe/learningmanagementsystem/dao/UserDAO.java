package com.alabelewe.learningmanagementsystem.dao;

import com.alabelewe.learningmanagementsystem.entity.User;

public interface UserDAO {

    public User findUserByUsername(String name);

}
