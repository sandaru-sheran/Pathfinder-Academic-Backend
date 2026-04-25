package com.example.security.controller.impl;

import com.example.security.controller.UserController;
import com.example.security.model.User;
import com.example.security.servise.UserServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/user")
public class UserControllerImpl implements UserController {

    @Autowired
    UserServise userServise;

    @PostMapping("/create")
    public boolean createUser(@RequestBody User user){
        return userServise.createUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user){
        return userServise.verify(user);
    }
}
