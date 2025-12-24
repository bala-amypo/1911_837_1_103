package com.example.demo.dto;

public class EmployeeDto {
    private String fullName;
    private String email;
    private String role;
    private String skills;
    private Integer maxWeeklyHours;

    public EmployeeDto() {}

    public EmployeeDto(String fullName, String email, String role, String skills, Integer maxWeeklyHours) {
        this.fullName = fullName;
        this.email = email;
        this.role = role;
        this.skills = skills;
        this.maxWeeklyHours = maxWeeklyHours;
    }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getSkills() { return skills; }
    public void setSkills(String skills) { this.skills = skills; }

    public Integer getMaxWeeklyHours() { return maxWeeklyHours; }
    public void setMaxWeeklyHours(Integer maxWeeklyHours) { this.maxWeeklyHours = maxWeeklyHours; }
}
