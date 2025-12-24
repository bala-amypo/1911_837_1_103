package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ValidationException;
import com.example.demo.model.Department;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.service.DepartmentService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department create(Department department) {
        // [cite: 183]
        if (departmentRepository.existsByName(department.getName())) {
            throw new ValidationException("exists");
        }
        return departmentRepository.save(department);
    }

    @Override
    public Department get(Long id) {
        // [cite: 295]
        return departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));
    }

    @Override
    public void delete(Long id) {
        Department d = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));
        departmentRepository.delete(d);
    }

    @Override
    public List<Department> getAll() {
        return departmentRepository.findAll();
    }
}