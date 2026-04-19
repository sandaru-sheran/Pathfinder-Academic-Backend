package com.example.security.model;

import lombok.Data;
import org.springframework.context.annotation.Bean;

@Data
public class user {
    private String usrname;
    private String password;

    public user(String usrname, String password) {
        this.usrname = usrname;
        this.password = password;
    }
}
