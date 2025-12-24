package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ShiftTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String templateName; [cite_start]// [cite: 188]
    private LocalTime startTime;
    private LocalTime endTime;
    private String requiredSkills;
    
    @ManyToOne
    private Department department;

    public ShiftTemplate() {}

    // Constructor used in Test 11 
    public ShiftTemplate(String templateName, LocalTime startTime, LocalTime endTime, String requiredSkills, Department department) {
        this.templateName = templateName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.requiredSkills = requiredSkills;
        this.department = department;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTemplateName() { return templateName; }
    public void setTemplateName(String templateName) { this.templateName = templateName; }
    public LocalTime getStartTime() { return startTime; }
    public void setStartTime(LocalTime startTime) { this.startTime = startTime; }
    public LocalTime getEndTime() { return endTime; }
    public void setEndTime(LocalTime endTime) { this.endTime = endTime; }
    
    // Test 22: Skill matching 
    public Set<String> getRequiredSkills() {
        if (requiredSkills == null || requiredSkills.isEmpty()) return new HashSet<>();
        return new HashSet<>(Arrays.asList(requiredSkills.split(",")));
    }
    public void setRequiredSkills(String requiredSkills) { this.requiredSkills = requiredSkills; }
    
    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }
}