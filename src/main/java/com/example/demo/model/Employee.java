package com.example.demo.entity;
import java.util.List;
import java.util.Arrays;
import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.persistence.UniqueConstraint;
@Entity
@Table(
    name = "employees",
    uniqueConstraints = {
        @UniqueConstraint(columnNames="email")
    }
)
public class Employee {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false)
    private String fullName;
    @Column(nullable=false,unique=true)
    private String email;
    @Column(nullable=false)
    private String role="STAFF"; 
    @Column
    private String skills; 
    @Column(nullable=false)
    private Integer maxWeeklyHours;
    @Column(nullable=false,updatable=false)
    private LocalDateTime createdAt;
    @PrePersist
    protected void onCreate() {
        this.createdAt=LocalDateTime.now();
    }
    public Employee() {
    }
    public Employee(String fullName,String email,String role,String skills,Integer maxWeeklyHours) {
        this.fullName=fullName;
        this.email=email;
        this.role=(role == null || role.isBlank()) ? "STAFF" : role;
        this.skills=skills;
        this.maxWeeklyHours=maxWeeklyHours;
    }
    public Long getId() {
        return id;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getSkills() {
        return skills;
    }
    public void setSkills(String skills) {
        this.skills = skills;
    }
@Transient
public List<String> getSkillList() {
    if (skills==null||skills.isBlank()) {
        return List.of();
    }
    return Arrays.asList(skills.split(","));
}
    public Integer getMaxWeeklyHours() {
        return maxWeeklyHours;
    }
    public void setMaxWeeklyHours(Integer maxWeeklyHours) {
        this.maxWeeklyHours = maxWeeklyHours;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
