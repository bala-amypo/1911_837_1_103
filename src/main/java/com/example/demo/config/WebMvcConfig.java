package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebMvcConfig {

    @Bean
    public JwtUtil jwtUtil() {
        return new JwtUtil("test-secret", 3600000);
    }
}
