package com.example.security.repository;

import com.example.security.model.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class userReposotory {

    @Autowired
    private DataSource dataSource;


    public user getUserByUsername(String username) throws SQLException {
        String sql = "SELECT * FROM user WHERE username=?";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new user(rs.getString("username"), rs.getString("password"));
            } else {
                return null;
            }

        }
    }
}