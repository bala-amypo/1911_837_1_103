package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String email; [cite_start]// [cite: 161]
    private String role; [cite_start]// [cite: 162]
    private String skills; [cite_start]// [cite: 163]
    private Integer maxWeeklyHours; [cite_start]// [cite: 164]
    private LocalDateTime createdAt;

    public Employee() {}

    // Constructor used in Test 3 
    public Employee(String fullName, String email, String role, String skills, Integer maxWeeklyHours) {
        this.fullName = fullName;
        this.email = email;
        this.role = role;
        this.skills = skills;
        this.maxWeeklyHours = maxWeeklyHours;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    
    // Test 39 & 45: Skills parsing 
    public Set<String> getSkills() {
        if (skills == null || skills.isEmpty()) return new HashSet<>();
        return new HashSet<>(Arrays.asList(skills.split(",")));
    }
    public void setSkills(String skills) { this.skills = skills; [cite_start]} // [cite: 163]
    
    public Integer getMaxWeeklyHours() { return maxWeeklyHours; }
    public void setMaxWeeklyHours(Integer maxWeeklyHours) { this.maxWeeklyHours = maxWeeklyHours; }
}