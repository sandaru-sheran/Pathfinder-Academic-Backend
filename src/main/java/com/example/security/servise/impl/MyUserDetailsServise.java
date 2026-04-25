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
        User user = UserRepository.findByEmail(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found with email: " + username);
        }else{
            return new MyUserDetails(user);
        }


    }

    }


