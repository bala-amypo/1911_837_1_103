package com.example.demo.service.impl;
import com.example.demo.exception.ResourceExistsException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.EmployeeAvailability;
import com.example.demo.repository.AvailabilityRepository;
import com.example.demo.service.AvailabilityService;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
@Service
public class AvailabilityServiceImpl implements AvailabilityService{
    private final AvailabilityRepository availabilityRepository;
    public AvailabilityServiceImpl(AvailabilityRepository availabilityRepository){
        this.availabilityRepository = availabilityRepository;
    }
    @Override
    public EmployeeAvailability create(EmployeeAvailability availability){
        availabilityRepository.findByEmployee_IdAndAvailableDate(
                availability.getEmployee().getId(),
                availability.getAvailableDate()
        ).ifPresent(existing -> {
            throw new ResourceExistsException("Availability record exists");
        });
        return availabilityRepository.save(availability);
    }
    @Override
    public EmployeeAvailability update(Long id, EmployeeAvailability availability){
        EmployeeAvailability existing = availabilityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Availability not found"));
        existing.setAvailableDate(availability.getAvailableDate());
        existing.setAvailable(availability.getAvailable());
        return availabilityRepository.save(existing);
    }
    @Override
    public void delete(Long id){
        EmployeeAvailability existing = availabilityRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Availability not found"));
        availabilityRepository.delete(existing);
    }
    @Override
    public List<EmployeeAvailability> getByDate(LocalDate date){
        return availabilityRepository.findByAvailableDateAndAvailable(date,true);
    }
}
