package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class EmployeeAvailability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Employee employee;
    
    private LocalDate availableDate;
    private Boolean available = true; [cite_start]// [cite: 204]

    public EmployeeAvailability() {}

    // Constructor used in Test 20 and Test 36 , 
    public EmployeeAvailability(Employee employee, LocalDate availableDate, Boolean available) {
        this.employee = employee;
        this.availableDate = availableDate;
        this.available = available;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Employee getEmployee() { return employee; }
    public void setEmployee(Employee employee) { this.employee = employee; }
    public LocalDate getAvailableDate() { return availableDate; }
    public void setAvailableDate(LocalDate availableDate) { this.availableDate = availableDate; }
    public Boolean getAvailable() { return available; }
    public void setAvailable(Boolean available) { this.available = available; }
}