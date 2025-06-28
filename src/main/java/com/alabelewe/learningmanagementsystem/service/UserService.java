package com.alabelewe.learningmanagementsystem.service;

import com.alabelewe.learningmanagementsystem.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    public User findByUserName(String userName);
}
