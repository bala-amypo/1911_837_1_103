package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ValidationException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        if (employeeRepository.existsByEmail(employee.getEmail())) {
            throw new ValidationException("exists");
        }
        if (employee.getMaxWeeklyHours() <= 0) {
            throw new ValidationException("must be > 0");
        }
        if (employee.getRole() == null) {
            employee.setRole("STAFF");
        }
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployee(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        Employee existing = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));
        
        if (!existing.getEmail().equals(employee.getEmail()) && 
            employeeRepository.existsByEmail(employee.getEmail())) {
            throw new ValidationException("exists");
        }
        existing.setFullName(employee.getFullName());
        return employeeRepository.save(existing);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee e = getEmployee(id);
        employeeRepository.delete(e);
    }

    @Override
    public Employee findByEmail(String email) {
        return employeeRepository.findByEmail(email).orElse(null);
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }
}