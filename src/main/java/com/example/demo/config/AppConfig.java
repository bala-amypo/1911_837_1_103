package com.example.demo.config;

import com.example.demo.service.AvailabilityService;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.ScheduleService;
import com.example.demo.service.impl.AvailabilityServiceImpl;
import com.example.demo.service.impl.DepartmentServiceImpl;
import com.example.demo.service.impl.EmployeeServiceImpl;
import com.example.demo.service.impl.ScheduleServiceImpl;
import com.example.demo.repository.AvailabilityRepository;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.GeneratedShiftScheduleRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public AvailabilityService availabilityService(AvailabilityRepository availabilityRepository,
                                                   EmployeeRepository employeeRepository) {
        return new AvailabilityServiceImpl(availabilityRepository, employeeRepository);
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
