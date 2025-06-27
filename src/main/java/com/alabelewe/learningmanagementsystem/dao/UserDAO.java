package com.alabelewe.learningmanagementsystem.dao;

import org.springframework.security.core.userdetails.User;

public interface UserDAO {

    public User findUserByName(String name);

}
