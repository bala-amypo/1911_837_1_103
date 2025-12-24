package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {

    @Bean
    public JwtUtil jwtUtil() {
        return new JwtUtil("my-secret-key", 3600000); // 1 hour validity
    }
}
