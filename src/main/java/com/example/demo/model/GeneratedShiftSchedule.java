package com.example.demo.model;
import java.time.LocalDate;
import java.time.LocalTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="generated_shift_schedule")
public class GeneratedShiftSchedule {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false)
    private LocalDate shiftDate;
    @Column(nullable=false)
    private LocalTime startTime;
    @Column(nullable=false)
    private LocalTime endTime;
    @ManyToOne
    @JoinColumn(name="shift_template_id",nullable=false)
    private ShiftTemplate shiftTemplate;
    @ManyToOne
    @JoinColumn(name="department_id",nullable=false)
    private Department department;
    @ManyToOne
    @JoinColumn(name="employee_id",nullable=false)
    private Employee employee;
    public GeneratedShiftSchedule(){}
    public GeneratedShiftSchedule(LocalDate shiftDate,LocalTime startTime,LocalTime endTime,ShiftTemplate shiftTemplate,Department department,Employee employee){
        this.shiftDate=shiftDate;
        this.startTime=startTime;
        this.endTime=endTime;
        this.shiftTemplate=shiftTemplate;
        this.department=department;
        this.employee=employee;
    }
    public Long getId(){
    return id;
}
public LocalDate getShiftDate(){
    return shiftDate;
}
public void setShiftDate(LocalDate shiftDate){
    this.shiftDate=shiftDate;
}
public LocalTime getStartTime(){
    return startTime;
}
public void setStartTime(LocalTime startTime){
    this.startTime=startTime;
}
public LocalTime getEndTime(){
    return endTime;
}
public void setEndTime(LocalTime endTime){
    this.endTime=endTime;
}
public ShiftTemplate getShiftTemplate(){
    return shiftTemplate;
}
public void setShiftTemplate(ShiftTemplate shiftTemplate){
    this.shiftTemplate=shiftTemplate;
}
public Department getDepartment(){
    return department;
}
public void setDepartment(Department department){
    this.department=department;
}
public Employee getEmployee(){
    return employee;
}
public void setEmployee(Employee employee){
    this.employee=employee;
}
}