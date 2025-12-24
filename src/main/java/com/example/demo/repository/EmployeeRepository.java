package com.example.demo.repository;

import com.example.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;
import java.time.LocalDate;
import com.example.demo.model.EmployeeAvailability;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    boolean existsByEmail(String email);        // ✅ required for tests
    Optional<Employee> findByEmail(String email); // ✅ required for service calls

    // This is for controller mock usage earlier
    List<EmployeeAvailability> findByEmployee_Id(Long employeeId);
}
