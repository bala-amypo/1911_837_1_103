package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class GeneratedShiftSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate shiftDate;
    private LocalTime startTime;
    private LocalTime endTime;
    
    @ManyToOne
    private ShiftTemplate shiftTemplate;
    @ManyToOne
    private Department department;
    @ManyToOne
    private Employee employee;

    public GeneratedShiftSchedule() {}

    public GeneratedShiftSchedule(LocalDate shiftDate, LocalTime startTime, LocalTime endTime, ShiftTemplate shiftTemplate, Department department, Employee employee) {
        this.shiftDate = shiftDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.shiftTemplate = shiftTemplate;
        this.department = department;
        this.employee = employee;
    }

    public LocalDate getShiftDate() { return shiftDate; }
    public void setShiftDate(LocalDate shiftDate) { this.shiftDate = shiftDate; }
    public Employee getEmployee() { return employee; }
    public void setEmployee(Employee employee) { this.employee = employee; }
    // Getters for other fields omitted for brevity but required for full JPA usage
}