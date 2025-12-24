package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name; [cite_start]// [cite: 176]
    private String description;
    private String requiredSkills; [cite_start]// [cite: 178]
    private LocalDateTime createdAt;

    public Department() {}

    // Constructor used in Test 8 
    public Department(String name, String description, String requiredSkills) {
        this.name = name;
        this.description = description;
        this.requiredSkills = requiredSkills;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    // Test 46: Parsing required skills 
    public Set<String> getRequiredSkills() {
        if (requiredSkills == null || requiredSkills.isEmpty()) return new HashSet<>();
        return new HashSet<>(Arrays.asList(requiredSkills.split(",")));
    }
    public void setRequiredSkills(String requiredSkills) { this.requiredSkills = requiredSkills; }
}