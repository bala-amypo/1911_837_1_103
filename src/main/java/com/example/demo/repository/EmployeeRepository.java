// package com.example.demo.repository;
// import com.example.demo.model.Employee;
// import org.springframework.data.jpa.repository.JpaRepository;
// import java.util.Optional;
// import java.util.List;
// public interface EmployeeRepository extends JpaRepository<Employee, Long>{
//     Optional<Employee>findByEmail(String email);
//     boolean existsByEmail(String email);
//     List<Employee>findAll();
// }
package com.example.demo.repository;

import com.example.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    boolean existsByEmail(String email); // 
    Optional<Employee> findByEmail(String email); // 
}