// package com.example.demo.model;
// import java.time.LocalDate;

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
//     name="employee_availability",
//     uniqueConstraints={
//         @UniqueConstraint(columnNames={"employee_id","availableDate"})
//     })
// public class EmployeeAvailability {
//     @Id
//     @GeneratedValue(strategy=GenerationType.IDENTITY)
//     private Long id;
//     @ManyToOne
//     @JoinColumn(name="employee_id",nullable=false)
//     private Employee employee;
//     @Column(nullable=false)
//     private LocalDate availableDate;
//     @Column(nullable=false)
//     private Boolean available=true;
//     public EmployeeAvailability(){}
//     public EmployeeAvailability(Employee employee,LocalDate availableDate,Boolean available){
//         this.employee=employee;
//         this.availableDate=availableDate;
//         this.available=available;
//     }
//     public Long getId(){
//     return id;
// }
// public Employee getEmployee(){
//     return employee;
// }
// public void setEmployee(Employee employee){
//     this.employee=employee;
// }
// public LocalDate getAvailableDate(){
//     return availableDate;
// }
// public void setAvailableDate(LocalDate availableDate){
//     this.availableDate=availableDate;
// }
// public Boolean getAvailable(){
//     return available;
// }
// public void setAvailable(Boolean available){
//     this.available=available;
// }
// }
package com.example.demo.model;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
@Entity
@Table(
    name = "employee_availability",
    uniqueConstraints = @UniqueConstraint(columnNames ={"employee_id","availableDate"})
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeAvailability{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional=false)
    @JoinColumn(name="employee_id",nullable=false)
    private Employee employee;
    @Column(nullable=false)
    private LocalDate availableDate;
    @Column(nullable=false)
    private Boolean available=true; 
}
