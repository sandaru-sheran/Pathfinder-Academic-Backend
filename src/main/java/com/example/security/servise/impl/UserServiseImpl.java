package com.example.security.servise.impl;

import com.example.security.model.User;
import com.example.security.repository.UserReposotry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiseImpl implements com.example.security.servise.UserServise {

    @Autowired
    UserReposotry userReposotry;

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
}
