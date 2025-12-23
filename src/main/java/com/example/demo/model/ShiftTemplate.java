// package com.example.demo.model;
// import java.time.LocalTime;
// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;
// import jakarta.persistence.Table;
// import jakarta.persistence.UniqueConstraint;
// @Entity
// @Table(
//     name="shift_templates",
//     uniqueConstraints={
//         @UniqueConstraint(columnNames={"templateName","department_id"})
//     })
// public class ShiftTemplate{
//     @Id
//     @GeneratedValue(strategy=GenerationType.IDENTITY)
//     private Long id;
//     @Column(nullable=false)
//     private String templateName;
//     @Column(nullable=false)
//     private LocalTime startTime;
//     @Column(nullable=false)
//     private LocalTime endTime;
//     @Column
//     private String requiredSkills;
//     @ManyToOne
//     @JoinColumn(name="department_id",nullable=false)
//     private Department department;
//     public ShiftTemplate(){}
//     public ShiftTemplate(String templateName,LocalTime startTime,LocalTime endTime,String requiredSkills,Department department){
//         this.templateName=templateName;
//         this.startTime=startTime;
//         this.endTime=endTime;
//         this.requiredSkills=requiredSkills;
//         this.department=department;
//     }
//     public Long getId(){
//     return id;
// }
// public String getTemplateName(){
//     return templateName;
// }
// public void setTemplateName(String templateName){
//     this.templateName=templateName;
// }
// public LocalTime getStartTime(){
//     return startTime;
// }
// public void setStartTime(LocalTime startTime){
//     this.startTime=startTime;
// }
// public LocalTime getEndTime(){
//     return endTime;
// }
// public void setEndTime(LocalTime endTime){
//     this.endTime=endTime;
// }
// public String getRequiredSkills(){
//     return requiredSkills;
// }
// public void setRequiredSkills(String requiredSkills){
//     this.requiredSkills=requiredSkills;
// }
// public Department getDepartment(){
//     return department;
// }
// public void setDepartment(Department department){
//     this.department=department;
// }
// }
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
    private String templateName;
    private LocalTime startTime;
    private LocalTime endTime;
    private String requiredSkills;
    
    @ManyToOne
    private Department department;

    public ShiftTemplate() {}

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
    
    public Set<String> getRequiredSkills() {
        if (requiredSkills == null || requiredSkills.isEmpty()) return new HashSet<>();
        return new HashSet<>(Arrays.asList(requiredSkills.split(",")));
    }
    public void setRequiredSkills(String requiredSkills) { this.requiredSkills = requiredSkills; }
    
    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }
}