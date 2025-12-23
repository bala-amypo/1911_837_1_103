package com.example.demo.service.impl;

import com.example.demo.model.ShiftTemplate;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.ShiftTemplateRepository;
import com.example.demo.service.ShiftTemplateService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ShiftTemplateServiceImpl implements ShiftTemplateService {
    private final ShiftTemplateRepository repository;
    private final DepartmentRepository departmentRepository;

    public ShiftTemplateServiceImpl(ShiftTemplateRepository repository, DepartmentRepository departmentRepository) {
        this.repository = repository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public ShiftTemplate create(ShiftTemplate template) {
        if (template.getEndTime().isBefore(template.getStartTime())) {
            throw new RuntimeException("after");
        }
        if (repository.findByTemplateNameAndDepartment_Id(template.getTemplateName(), template.getDepartment().getId()).isPresent()) {
            throw new RuntimeException("unique");
        }
        return repository.save(template);
    }

    @Override
    public List<ShiftTemplate> getByDepartment(Long departmentId) {
        return repository.findByDepartment_Id(departmentId);
    }

    @Override
    public List<ShiftTemplate> getAll() {
        return repository.findAll();
    }
}