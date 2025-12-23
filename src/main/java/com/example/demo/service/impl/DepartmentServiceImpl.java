package com.example.demo.service.impl;

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
        if (departmentRepository.existsByName(department.getName())) {
            throw new RuntimeException("exists");
        }
        return departmentRepository.save(department);
    }

    @Override
    public Department get(Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
    }

    @Override
    public void delete(Long id) {
        Department d = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
        departmentRepository.delete(d);
    }

    @Override
    public List<Department> getAll() {
        return departmentRepository.findAll();
    }
}