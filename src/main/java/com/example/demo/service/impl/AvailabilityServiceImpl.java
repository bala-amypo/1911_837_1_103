package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ValidationException;
import com.example.demo.model.EmployeeAvailability;
import com.example.demo.repository.AvailabilityRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.AvailabilityService;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class AvailabilityServiceImpl implements AvailabilityService {
    private final AvailabilityRepository availabilityRepository;
    private final EmployeeRepository employeeRepository;

    public AvailabilityServiceImpl(AvailabilityRepository availabilityRepository, EmployeeRepository employeeRepository) {
        this.availabilityRepository = availabilityRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeAvailability create(EmployeeAvailability availability) {
        // [cite: 208]
        if (availabilityRepository.findByEmployee_IdAndAvailableDate(
                availability.getEmployee().getId(), availability.getAvailableDate()).isPresent()) {
            throw new ValidationException("exists");
        }
        return availabilityRepository.save(availability);
    }

    @Override
    public EmployeeAvailability update(Long id, EmployeeAvailability availability) {
        EmployeeAvailability existing = availabilityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));
        existing.setAvailable(availability.getAvailable());
        return availabilityRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        EmployeeAvailability ea = availabilityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));
        availabilityRepository.delete(ea);
    }

    @Override
    public List<EmployeeAvailability> getByDate(LocalDate date) {
        return availabilityRepository.findByAvailableDateAndAvailable(date, true);
    }
}