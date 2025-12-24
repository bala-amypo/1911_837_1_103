package com.example.demo.repository;

import com.example.demo.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    // ✅ MUST match entity field name (departmentName)
    boolean existsByDepartmentName(String departmentName);

    Optional<Department> findByDepartmentName(String departmentName);

    List<Department> findAll();
}
