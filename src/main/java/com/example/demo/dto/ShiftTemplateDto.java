package com.example.demo.dto;

import java.time.LocalTime;

public class ShiftTemplateDto {
    private String templateName;
    private LocalTime startTime;
    private LocalTime endTime;
    private String requiredSkills;
    private Long departmentId;

    public ShiftTemplateDto() {}

    public ShiftTemplateDto(String templateName, LocalTime startTime, LocalTime endTime, String requiredSkills, Long departmentId) {
        this.templateName = templateName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.requiredSkills = requiredSkills;
        this.departmentId = departmentId;
    }

    public String getTemplateName() { return templateName; }
    public void setTemplateName(String templateName) { this.templateName = templateName; }

    public LocalTime getStartTime() { return startTime; }
    public void setStartTime(LocalTime startTime) { this.startTime = startTime; }

    public LocalTime getEndTime() { return endTime; }
    public void setEndTime(LocalTime endTime) { this.endTime = endTime; }

    public String getRequiredSkills() { return requiredSkills; }
    public void setRequiredSkills(String requiredSkills) { this.requiredSkills = requiredSkills; }

    public Long getDepartmentId() { return departmentId; }
    public void setDepartmentId(Long departmentId) { this.departmentId = departmentId; }
}
