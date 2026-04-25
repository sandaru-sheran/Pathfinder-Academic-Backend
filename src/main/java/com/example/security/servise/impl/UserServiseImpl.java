package com.example.security.servise.impl;

import com.example.security.model.User;
import com.example.security.repository.UserReposotry;
import com.example.security.servise.JWTService;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiseImpl implements com.example.security.servise.UserServise {

    @Autowired
    UserReposotry userReposotry;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JWTService jwtService;


    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);

    @Override
    public boolean createUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        User user1 = userReposotry.save(user);
        if(user1.getId() != null){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String verify(User user) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
        if(authentication.isAuthenticated()){

            User authenticatedUser = userReposotry.findByEmail(user.getEmail());
            return jwtService.generateToken(authenticatedUser);
        }else {
            return "User is not authenticated";
        }
    }
}
