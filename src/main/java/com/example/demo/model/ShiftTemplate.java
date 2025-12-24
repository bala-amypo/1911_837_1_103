package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalTime;

@Entity
public class ShiftTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String templateName;

    private LocalTime startTime;
    private LocalTime endTime;

    private String requiredSkills;

    @ManyToOne
    private Department department;

    public ShiftTemplate() {}

    public ShiftTemplate(String name, LocalTime start, LocalTime end, String skills, Department dept) {
        this.templateName = name;
        this.startTime = start;
        this.endTime = end;
        this.requiredSkills = skills;
        this.department = dept;
    }

    public String getTemplateName() { return templateName; }
    public void setTemplateName(String templateName) { this.templateName = templateName; }

    public LocalTime getStartTime() { return startTime; }
    public void setStartTime(LocalTime startTime) { this.startTime = startTime; }

    public LocalTime getEndTime() { return endTime; }
    public void setEndTime(LocalTime endTime) { this.endTime = endTime; }

    public String getRequiredSkills() { return requiredSkills; }
    public Department getDepartment() {
    return department;
}

public void setRequiredSkills(String requiredSkills) {
    this.requiredSkills = requiredSkills;
}

public void setDepartment(Department department) {
    this.department = department;
}

}
