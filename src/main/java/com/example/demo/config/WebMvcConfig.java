package com.example.demo.config;

import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebMvcConfig {
@Bean
public AvailabilityService availabilityService(AvailabilityRepository repo, EmployeeRepository empRepo) {
    return new AvailabilityServiceImpl(repo, empRepo);
}

    @Bean
    public UserService userService(UserRepository userRepository) {
        return new UserServiceImpl(userRepository);
    }
}
