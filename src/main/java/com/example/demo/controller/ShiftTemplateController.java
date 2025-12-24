package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.ShiftTemplate;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.service.ShiftTemplateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/templates")
public class ShiftTemplateController {
    private final ShiftTemplateService service;
    private final DepartmentRepository deptRepo;

    public ShiftTemplateController(ShiftTemplateService service, DepartmentRepository deptRepo) {
        this.service = service;
        this.deptRepo = deptRepo;
    }

    @GetMapping("/")
    public ResponseEntity<List<ShiftTemplate>> list() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/department/{departmentId}")
    public ResponseEntity<List<ShiftTemplate>> listByDept(@PathVariable Long departmentId) {
        return ResponseEntity.ok(service.getByDepartment(departmentId));
    }
    
    @PostMapping("/department/{departmentId}")
    public ResponseEntity<ShiftTemplate> create(@RequestBody ShiftTemplate template, @PathVariable Long departmentId) {
        template.setDepartment(deptRepo.findById(departmentId)
            .orElseThrow(() -> new ResourceNotFoundException("Department not found")));
        return ResponseEntity.ok(service.create(template));
    }
}