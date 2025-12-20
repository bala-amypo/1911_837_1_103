package com.example.demo.service.impl;
import com.example.demo.exception.ResourceExistsException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository employeeRepository;
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee createEmployee(Employee employee){
        if (employeeRepository.existsByEmail(employee.getEmail())){
            throw new ResourceExistsException("Employee with this email exists");
        }
        if (employee.getMaxWeeklyHours()==null||employee.getMaxWeeklyHours()<=0){
            throw new IllegalArgumentException("maxWeeklyHours must be greater than 0");
        }
        if (employee.getRole()==null||employee.getRole().isBlank()) {
            employee.setRole("STAFF");
        }
        return employeeRepository.save(employee);
    }
    @Override
    public Employee getEmployee(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
    }
    @Override
    public Employee updateEmployee(Long id, Employee employee){
        Employee existing = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
        if (!existing.getEmail().equals(employee.getEmail()) &&
                employeeRepository.existsByEmail(employee.getEmail())){
            throw new ResourceExistsException("Employee with this email exists");
        }
        if (employee.getMaxWeeklyHours() == null || employee.getMaxWeeklyHours() <= 0){
            throw new IllegalArgumentException("maxWeeklyHours must be greater than 0");
        }
        existing.setFullName(employee.getFullName());
        existing.setEmail(employee.getEmail());
        existing.setRole(employee.getRole() != null ? employee.getRole() : "STAFF");
        existing.setSkills(employee.getSkills());
        existing.setMaxWeeklyHours(employee.getMaxWeeklyHours());
        return employeeRepository.save(existing);
    }

    @Override
    public void deleteEmployee(Long id){
        Employee existing = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
        employeeRepository.delete(existing);
    }
    @Override
    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }
    @Override
    public Employee findByEmail(String email){
        return employeeRepository.findByEmail(email)
                .orElseThrow(()->new ResourceNotFoundException("Employee not found"));
    }
}
