package com.example.demo.controller;

import com.example.demo.model.EmployeeAvailability;
import com.example.demo.repository.AvailabilityRepository;
import com.example.demo.service.AvailabilityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/availability")
public class AvailabilityController {

    private final AvailabilityService availabilityService;
    private final AvailabilityRepository availabilityRepository; // repo for employee availability

    public AvailabilityController(AvailabilityService availabilityService,
                                  AvailabilityRepository availabilityRepository) {
        this.availabilityService = availabilityService;
        this.availabilityRepository = availabilityRepository;
    }

    @PostMapping("/{employeeId}")
    public ResponseEntity<EmployeeAvailability> create(@PathVariable Long employeeId,
                                                       @RequestBody EmployeeAvailability availability) {
        availability.getEmployee().setId(employeeId);
        return ResponseEntity.ok(availabilityService.create(availability));
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<EmployeeAvailability>> byEmployee(@PathVariable Long employeeId) {
        return ResponseEntity.ok(availabilityRepository.findByEmployee_Id(employeeId)); // ✅ correct method
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<EmployeeAvailability>> byDate(@PathVariable String date) {
        LocalDate parsed = LocalDate.parse(date); // tests expect parse not to throw
        return ResponseEntity.ok(availabilityService.getByDate(parsed));
    }
}
