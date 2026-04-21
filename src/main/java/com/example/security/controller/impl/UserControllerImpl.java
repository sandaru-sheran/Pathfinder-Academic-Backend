package com.example.security.controller.impl;

import com.example.security.controller.UserController;
import com.example.security.model.User;
import com.example.security.servise.UserServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserControllerImpl implements UserController {

    @Autowired
    UserServise userServise;

    @PostMapping("/create")
    public boolean createUser(@RequestBody User user){
        return userServise.createUser(user);
    }
}
