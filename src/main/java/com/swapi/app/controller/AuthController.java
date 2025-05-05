package com.swapi.app.controller;

import com.swapi.app.security.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/swapi")
public class AuthController {

    @Value("${mock.username}")
    private String mockUsername;

    @Value("${mock.password}")
    private String mockPassword;

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        if (mockUsername.equals(username) && mockPassword.equals(password)) {
            return JwtTokenUtil.generateToken(username);
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }
}
