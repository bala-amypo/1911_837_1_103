package com.example.demo.controller;

import com.example.demo.config.JwtUtil;
import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    public AuthController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        return ResponseEntity.ok(userService.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest authRequest) {
        // 1. (Optional) Add logic here to check if password matches DB
        // User u = userService.findByEmail(authRequest.getEmail());
        // if(u == null || !u.getPassword().equals(authRequest.getPassword())) throw new RuntimeException("Invalid");

        // 2. Generate the real token
        String token = jwtUtil.generateToken(authRequest.getEmail());
        
        // 3. Return the token
        return ResponseEntity.ok(new AuthResponse(token));
    }
}