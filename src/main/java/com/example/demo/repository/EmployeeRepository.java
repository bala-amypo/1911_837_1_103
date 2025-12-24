package com.example.demo.repository;

import com.example.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    boolean existsByEmail(String email);          // used in tests/service
    Optional<Employee> findByEmail(String email); // used in service
    List<Employee> findAll();                    // mock tests expect this
}
