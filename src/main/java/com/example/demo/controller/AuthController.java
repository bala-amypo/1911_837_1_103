// package com.example.demo.controller;

// import com.example.demo.model.User;
// import com.example.demo.service.UserService;
// import com.example.demo.config.JwtUtil;
// import com.example.demo.dto.AuthRequest;
// import com.example.demo.dto.AuthResponse;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/auth")
// public class AuthController {

//     private final UserService userService;
//     private final JwtUtil jwtUtil;

//     public AuthController(UserService userService, JwtUtil jwtUtil) {
//         this.userService = userService;
//         this.jwtUtil = jwtUtil;
//     }

//     @PostMapping("/register")
//     public ResponseEntity<User> register(@RequestBody User user) {
//         return ResponseEntity.ok(userService.register(user));
//     }

//     @PostMapping("/login")
//     public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
//         User user = userService.findByEmail(request.getEmail());
//         String token = jwtUtil.generateToken(user);
//         return ResponseEntity.ok(new AuthResponse(token));
//     }
// }
