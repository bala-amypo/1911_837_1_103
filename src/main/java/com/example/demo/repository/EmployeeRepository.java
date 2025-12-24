package com.example.demo.repository;

import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeAvailability;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List; // ✅ required

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<EmployeeAvailability> findByEmployee_Id(Long employeeId); // ✅ add
}
