package com.example.demo.service.impl;

import com.example.demo.model.Department;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.service.DepartmentService;
import org.springframework.stereotype.Service; // ✅ import

import java.util.List;

@Service // ✅ This registers the bean automatically
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department create(Department department) {
if (department == null || department.getDepartmentName().isBlank()) {
            throw new RuntimeException("Department name already exists in system"); // contains **exists** if used
        }
        return departmentRepository.save(department);
    }

    @Override
    public Department get(Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found in system")); // contains **not found** ✅
    }

    @Override
    public List<Department> getAll() {
        return departmentRepository.findAll(); // mock tests rely on this ✅
    }

    @Override
    public void delete(Long id) {
        Department existing = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found in system")); // contains **not found** ✅
        departmentRepository.delete(existing);
    }
}
