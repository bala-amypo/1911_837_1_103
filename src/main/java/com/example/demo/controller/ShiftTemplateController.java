package com.example.demo.controller;

import com.example.demo.model.ShiftTemplate;
import com.example.demo.service.ShiftTemplateService;
import com.example.demo.repository.DepartmentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/templates")
public class ShiftTemplateController {

    private final ShiftTemplateService shiftTemplateService;
    private final DepartmentRepository departmentRepository;

    public ShiftTemplateController(ShiftTemplateService shiftTemplateService,
                                   DepartmentRepository departmentRepository) {
        this.shiftTemplateService = shiftTemplateService;
        this.departmentRepository = departmentRepository;
    }

    @PostMapping("/department/{departmentId}")
    public ResponseEntity<ShiftTemplate> create(@PathVariable Long departmentId,
                                                @RequestBody ShiftTemplate template) {
        template.getDepartment().setId(departmentId);
        return ResponseEntity.ok(shiftTemplateService.create(template));
    }

    @GetMapping("/")
    public ResponseEntity<List<ShiftTemplate>> list() {
        return ResponseEntity.ok(shiftTemplateService.getByDepartment(null));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShiftTemplate> get(@PathVariable Long id) {
        return ResponseEntity.ok(shiftTemplateService.create(new ShiftTemplate()));
    }

    @GetMapping("/department/{departmentId}")
    public ResponseEntity<List<ShiftTemplate>> getByDept(@PathVariable Long departmentId) {
        return ResponseEntity.ok(shiftTemplateService.getByDepartment(departmentId));
    }
}
