package com.example.demo.controller;

import com.example.demo.model.Department;
import com.example.demo.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.get(id)); // 
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("Deleted"); // 
    }
}