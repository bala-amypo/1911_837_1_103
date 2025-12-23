// package com.example.demo.model;
// import jakarta.persistence.*;
// import java.time.LocalDateTime;
// import java.util.ArrayList;
// import java.util.List;
// @Entity
// @Table(
//     name = "departments",
//     uniqueConstraints={@UniqueConstraint(columnNames = "name")})
// public class Department{
//     @Id
//     @GeneratedValue(strategy=GenerationType.IDENTITY)
//     private Long id;
//     @Column(nullable=false,unique =true)
//     private String name;
//     @Column
//     private String description;
//     @Column
//     private String requiredSkills;
//     @Column(nullable=false,updatable=false)
//     private LocalDateTime createdAt;
//     @OneToMany(mappedBy="department")
//     private List<ShiftTemplate> shiftTemplates=new ArrayList<>();
//     @OneToMany(mappedBy="department")
//     private List<GeneratedShiftSchedule> schedules=new ArrayList<>();
//     @PrePersist
//     protected void onCreate() {
//         this.createdAt=LocalDateTime.now();
//     }
//     public Department() {
//     }
//     public Department(String name, String description, String requiredSkills) {
//         this.name=name;
//         this.description=description;
//         this.requiredSkills=requiredSkills;
//     }
//     public Long getId() {
//         return id;
//     }
//     public String getName() {
//         return name;
//     }
//     public void setName(String name) {
//         this.name=name;
//     }
//     public String getDescription() {
//         return description;
//     }
//     public void setDescription(String description) {
//         this.description=description;
//     }
//     public String getRequiredSkills() {
//         return requiredSkills;
//     }
//     public void setRequiredSkills(String requiredSkills) {
//         this.requiredSkills=requiredSkills;
//     }
//     public LocalDateTime getCreatedAt() {
//         return createdAt;
//     }
//     @Transient
// public List<String> getRequiredSkillList() {
//     if (requiredSkills==null||requiredSkills.isBlank()) {
//         return List.of();
//     }

//     List<String> list=new ArrayList<>();
//     for (String skill:requiredSkills.split(",")) {
//         list.add(skill);
//     }
//     return list;
// }
// }
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