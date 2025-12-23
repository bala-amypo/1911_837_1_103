package com.example.demo.service.impl;

import com.example.demo.model.EmployeeAvailability;
import com.example.demo.repository.AvailabilityRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.AvailabilityService;
import java.time.LocalDate;
import java.util.List;

public class AvailabilityServiceImpl implements AvailabilityService {
    private final AvailabilityRepository availabilityRepository;
    private final EmployeeRepository employeeRepository;

    public AvailabilityServiceImpl(AvailabilityRepository availabilityRepository, EmployeeRepository employeeRepository) {
        this.availabilityRepository = availabilityRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeAvailability create(EmployeeAvailability availability) {
        // Test 20: Availability Unique check 
        if (availabilityRepository.findByEmployee_IdAndAvailableDate(
                availability.getEmployee().getId(), availability.getAvailableDate()).isPresent()) {
            throw new RuntimeException("exists");
        }
        return availabilityRepository.save(availability);
    }

    @Override
    public EmployeeAvailability update(Long id, EmployeeAvailability availability) {
        EmployeeAvailability existing = availabilityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
        // Test 34: Update logic 
        existing.setAvailable(availability.getAvailable());
        return availabilityRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        EmployeeAvailability ea = availabilityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
        availabilityRepository.delete(ea);
    }

    @Override
    public List<EmployeeAvailability> getByDate(LocalDate date) {
        return availabilityRepository.findByAvailableDateAndAvailable(date, true);
    }
}