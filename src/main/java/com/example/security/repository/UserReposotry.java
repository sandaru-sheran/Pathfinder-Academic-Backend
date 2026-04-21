package com.example.security.repository;

import com.example.security.model.User;

import java.sql.SQLException;

public interface UserReposotry {
    boolean createUser(User user);
    User getUserByUsername(String username)throws SQLException;
}
