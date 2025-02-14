package com.example.campusbookshare.controller;

import com.example.campusbookshare.dto.LoginRequest;
import com.example.campusbookshare.model.User;
import com.example.campusbookshare.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public User login(@RequestBody LoginRequest loginRequest) {
        return authService.authenticateUser(loginRequest.getUsername(), loginRequest.getPassword());
    }
}