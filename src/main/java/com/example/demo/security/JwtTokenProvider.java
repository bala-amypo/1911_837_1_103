// package com.example.demo.security;

// import com.example.demo.model.User;
// import com.example.demo.config.JwtUtil;

// public class JwtTokenProvider {

//     private final JwtUtil jwtUtil;

//     public JwtTokenProvider(JwtUtil jwtUtil) {
//         this.jwtUtil = jwtUtil;
//     }

//     public String createToken(User user) {
//         return jwtUtil.generateToken(user);
//     }

//     public boolean validateToken(String token) {
//         return jwtUtil.validateToken(token);
//     }

//     public String getEmail(String token) {
//         return jwtUtil.getEmailFromToken(token);
//     }

//     public String getRole(String token) {
//         return jwtUtil.getRoleFromToken(token);
//     }

//     public Long getUserId(String token) {
//         return jwtUtil.getUserIdFromToken(token);
//     }
// }
