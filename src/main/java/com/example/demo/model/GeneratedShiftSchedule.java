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

    public void setShiftDate(LocalDate shiftDate) {
        this.shiftDate = shiftDate;
    }
}
