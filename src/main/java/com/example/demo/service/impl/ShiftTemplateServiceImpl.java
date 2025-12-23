package com.example.demo.service.impl;

import com.example.demo.model.ShiftTemplate;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.ShiftTemplateRepository;
import com.example.demo.service.ShiftTemplateService;
import java.util.List;

public class ShiftTemplateServiceImpl implements ShiftTemplateService {
    private final ShiftTemplateRepository repository;
    private final DepartmentRepository departmentRepository;

    public ShiftTemplateServiceImpl(ShiftTemplateRepository repository, DepartmentRepository departmentRepository) {
        this.repository = repository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public ShiftTemplate create(ShiftTemplate template) {
        // Test 12: Invalid time 
        if (template.getEndTime().isBefore(template.getStartTime())) {
            throw new RuntimeException("after");
        }
        // Test 33: Unique within department 
        if (repository.findByTemplateNameAndDepartment_Id(template.getTemplateName(), template.getDepartment().getId()).isPresent()) {
            throw new RuntimeException("unique");
        }
        return repository.save(template);
    }

    @Override
    public List<ShiftTemplate> getByDepartment(Long departmentId) {
        return repository.findByDepartment_Id(departmentId);
    }
}