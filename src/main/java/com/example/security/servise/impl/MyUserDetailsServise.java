package com.example.security.servise.impl;

import com.example.security.model.User;
import com.example.security.model.MyUserDetails;
import com.example.security.repository.UserReposotry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class MyUserDetailsServise implements UserDetailsService {

    @Autowired
    private UserReposotry UserRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user;

        try {
            user = UserRepository.findByEmail(username);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return new MyUserDetails(user);
    }
}
