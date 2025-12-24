package com.example.demo.controller;

import com.example.demo.model.EmployeeAvailability;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.AvailabilityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/availability")
public class AvailabilityController {
    private final AvailabilityService service;
    private final EmployeeRepository empRepo;

    // Constructor matching Test 41 
    public AvailabilityController(AvailabilityService service, EmployeeRepository empRepo) {
        this.service = service;
        this.empRepo = empRepo;
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<EmployeeAvailability>> byDate(@PathVariable String date) {
        LocalDate d = LocalDate.parse(date);
        return ResponseEntity.ok(service.getByDate(d)); // 
    }
}