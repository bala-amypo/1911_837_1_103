package com.example.demo.service.impl;

import com.example.demo.model.Department;
import com.example.demo.model.ShiftTemplate;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.ShiftTemplateRepository;
import com.example.demo.service.ShiftTemplateService;
import java.time.LocalTime;
import java.util.List;
import org.springframework.stereotype.Service;
@Service
public class ShiftTemplateServiceImpl implements ShiftTemplateService {

    private final ShiftTemplateRepository shiftTemplateRepository;
    private final DepartmentRepository departmentRepository;

    public ShiftTemplateServiceImpl(ShiftTemplateRepository shiftTemplateRepository,
                                    DepartmentRepository departmentRepository) {
        this.shiftTemplateRepository = shiftTemplateRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public ShiftTemplate create(ShiftTemplate template) {
        Department dept = departmentRepository.findById(template.getDepartment().getId())
                .orElseThrow(() -> new RuntimeException("Department not found"));

        if (template.getEndTime().isBefore(template.getStartTime()) ||
                template.getEndTime().equals(template.getStartTime())) {
            throw new RuntimeException("Shift endTime must be after startTime");
        }

        if (shiftTemplateRepository.findByTemplateNameAndDepartment_Id(template.getTemplateName(), dept.getId()).isPresent()) {
            throw new RuntimeException("Shift template already unique");
        }

        template.setStartTime(template.getStartTime());
        template.setEndTime(template.getEndTime());
        template.setTemplateName(template.getTemplateName());
        template.setRequiredSkills(template.getRequiredSkills());
        template.setDepartment(dept);

        return shiftTemplateRepository.save(template);
    }

    @Override
    public List<ShiftTemplate> getByDepartment(Long departmentId) {
        return shiftTemplateRepository.findByDepartment_Id(departmentId);
    }
}
