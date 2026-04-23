package com.example.security.controller;

import com.example.security.model.User;
import com.example.security.servise.UserServise;

public interface UserController {
    boolean createUser(User user);

}
