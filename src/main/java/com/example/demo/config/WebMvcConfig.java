package com.example.demo.config;

import com.example.demo.repository.AvailabilityRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.AvailabilityService;
import com.example.demo.service.impl.AvailabilityServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebMvcConfig {

    @Bean
    public AvailabilityService availabilityService(AvailabilityRepository availabilityRepository,
                                                   EmployeeRepository employeeRepository) {
        return new AvailabilityServiceImpl(availabilityRepository, employeeRepository);
    }
}
