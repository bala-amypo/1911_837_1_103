package com.example.demo.repository;

import com.example.demo.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Optional<Department> findById(Long id);
    boolean existsByName(String name);
    List<Department> findAll();
}
