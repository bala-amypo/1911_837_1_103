package com.example.demo.controller;
import com.example.demo.model.EmployeeAvailability;
import com.example.demo.service.AvailabilityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
@RestController
@RequestMapping("/api/availability")
public class AvailabilityController{
    private final AvailabilityService availabilityService;
    public AvailabilityController(AvailabilityService availabilityService){
        this.availabilityService = availabilityService;
    }
    @PostMapping("/{employeeId}")
    public ResponseEntity<EmployeeAvailability> create(@PathVariable Long employeeId,@RequestBody EmployeeAvailability availability) {
        availability.getEmployee().setId(employeeId); 
        EmployeeAvailability saved = availabilityService.create(availability);
        return ResponseEntity.ok(saved);
    }
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeAvailability> update(@PathVariable Long id,@RequestBody EmployeeAvailability availability) {
        EmployeeAvailability updated = availabilityService.update(id, availability);
        return ResponseEntity.ok(updated);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        availabilityService.delete(id);
        return ResponseEntity.ok("Deleted");
    }
    @GetMapping("/date/{date}")
    public ResponseEntity<List<EmployeeAvailability>> getByDate(@PathVariable LocalDate date){
        List<EmployeeAvailability> availabilities=availabilityService.getByDate(date);
        return ResponseEntity.ok(availabilities);
    }
}
