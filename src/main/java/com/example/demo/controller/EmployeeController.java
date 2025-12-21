package com.example.demo.controller;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
@RestController
@RequestMapping("/api/employees")
public class EmployeeController{
    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }
    @PostMapping("/register")
    public ResponseEntity<Employee> register(@RequestBody Employee employee){
        logger.info("Received employee registration payload: {}", employee);
        Employee saved = employeeService.createEmployee(employee);
        return ResponseEntity.ok(saved);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAll(){
        return ResponseEntity.ok(employeeService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id){
        return ResponseEntity.ok(employeeService.getEmployee(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@RequestBody Employee employee){
        logger.info("Updating employee with id {}: {}",id,employee);
        return ResponseEntity.ok(employeeService.updateEmployee(id,employee));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id){
        logger.info("Deleting employee with id {}", id);
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Deleted");
    }
}
