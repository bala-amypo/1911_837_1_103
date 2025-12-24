package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String departmentName; // this is the actual field

    private LocalDateTime createdAt = LocalDateTime.now();

    public Department() {}

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    // ✅ Required Getter
    public String getDepartmentName() {
        return departmentName;
    }

    // ✅ Required Setter
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
