package com.example.security.repository.impl;

import com.example.security.model.User;
import com.example.security.repository.UserReposotry;
import com.example.security.util.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserReposotoryImpl implements UserReposotry {

    @Autowired
    private DataSource dataSource;


    @Override
    public boolean createUser(User user)  {
        String sql = "INSERT INTO users (email,password,role,registration_number,first_name,last_name,is_enabled) VALUES (?,?,?,?,?,?,?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);) {

            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.setString(3, String.valueOf(user.getRole()));
            ps.setString(4, user.getRegistrationNumber());
            ps.setString(5, user.getFirstName());
            ps.setString(6, user.getLastName());
            ps.setBoolean(7, user.getIsEnabled());
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public User getUserByUsername(String username) throws SQLException {
        String sql = "SELECT * FROM users WHERE email=?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);) {

            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getLong("id"),
                        rs.getString("password"),
                        rs.getString("email"),
                        UserRole.valueOf(rs.getString("role").toUpperCase()),
                        rs.getString("registration_number"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getBoolean("is_enabled")
                );
            } else {
                return null;
            }

        }
    }
}