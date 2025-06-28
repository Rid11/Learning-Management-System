package com.alabelewe.learningmanagementsystem.service;



import com.alabelewe.learningmanagementsystem.dao.RoleDAO;
import com.alabelewe.learningmanagementsystem.dao.UserDAO;
import com.alabelewe.learningmanagementsystem.entity.Role;
import com.alabelewe.learningmanagementsystem.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    private UserDAO userDAO;
    private RoleDAO roleDAO;

    private UserServiceImpl(UserDAO userDAO, RoleDAO roleDAO) {
        this.userDAO = userDAO;
        this.roleDAO = roleDAO;
    }

    @Override
    public User findByUserName(String userName){
        return userDAO.findUserByUsername(userName);
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException{
        User user = userDAO.findUserByUsername(name);
        
        if(user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
