package com.example.demo.security;

import com.example.demo.service.EmployeeService;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.impl.EmployeeServiceImpl;
import com.example.demo.service.impl.DepartmentServiceImpl;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.DepartmentRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public EmployeeService employeeService(EmployeeRepository employeeRepository) {
        return new EmployeeServiceImpl(employeeRepository);
    }

    @Bean
    public DepartmentService departmentService(DepartmentRepository departmentRepository) {
        return new DepartmentServiceImpl(departmentRepository);
    }
    @Bean
public ScheduleService scheduleService(GeneratedShiftScheduleRepository scheduleRepository) {
    return new ScheduleServiceImpl(scheduleRepository);
}

}
