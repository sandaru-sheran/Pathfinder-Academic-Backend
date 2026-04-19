package com.example.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hello {

    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }

    @PostMapping("/post")
    public String hello(String text){
        return text;
    }
}
