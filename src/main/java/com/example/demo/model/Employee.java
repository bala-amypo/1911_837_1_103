package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "employees", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String role = "STAFF";

    @Column
    private String skills;

    @Column(nullable = false)
    private Integer maxWeeklyHours;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    public List<String> getSkillsList() {
        if (skills == null || skills.isBlank()) {
            return List.of();
        }
        return Arrays.asList(skills.split(","));
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", skills='" + skills + '\'' +
                ", maxWeeklyHours=" + maxWeeklyHours +
                ", createdAt=" + createdAt +
                '}';
    }
}
