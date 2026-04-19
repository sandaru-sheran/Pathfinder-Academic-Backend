package com.example.security;

import com.example.security.model.user;
import com.example.security.model.myUserDetails;
import com.example.security.repository.userReposotory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class MyUserDetailsServise implements UserDetailsService {

    @Autowired
    private userReposotory userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        user user;

        try {
            user = userRepository.getUserByUsername(username);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return new myUserDetails(user);
    }
}
