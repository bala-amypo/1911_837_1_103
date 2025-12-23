package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.ScheduleService;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    private final ShiftTemplateRepository templateRepo;
    private final AvailabilityRepository availabilityRepo;
    private final EmployeeRepository employeeRepo;
    private final GeneratedShiftScheduleRepository scheduleRepo;
    private final DepartmentRepository deptRepo;

    public ScheduleServiceImpl(ShiftTemplateRepository templateRepo, AvailabilityRepository availabilityRepo, 
                               EmployeeRepository employeeRepo, GeneratedShiftScheduleRepository scheduleRepo, 
                               DepartmentRepository deptRepo) {
        this.templateRepo = templateRepo;
        this.availabilityRepo = availabilityRepo;
        this.employeeRepo = employeeRepo;
        this.scheduleRepo = scheduleRepo;
        this.deptRepo = deptRepo;
    }

    @Override
    public List<GeneratedShiftSchedule> generateForDate(LocalDate date) {
        List<GeneratedShiftSchedule> schedules = new ArrayList<>();
        
        List<EmployeeAvailability> availableEmployees = availabilityRepo.findByAvailableDateAndAvailable(date, true);
        List<Department> departments = deptRepo.findAll();

        for (Department dept : departments) {
            List<ShiftTemplate> templates = templateRepo.findByDepartment_Id(dept.getId());
            
            for (ShiftTemplate template : templates) {
                for (EmployeeAvailability av : availableEmployees) {
                    Employee emp = av.getEmployee();
                    Set<String> empSkills = emp.getSkills();
                    Set<String> templateSkills = template.getRequiredSkills();
                    
                    boolean matches = true;
                    for (String req : templateSkills) {
                        if (!empSkills.contains(req)) {
                            matches = false;
                            break;
                        }
                    }
                    
                    if (matches) {
                        GeneratedShiftSchedule sch = new GeneratedShiftSchedule(
                                date, template.getStartTime(), template.getEndTime(), 
                                template, dept, emp);
                        schedules.add(scheduleRepo.save(sch));
                        break; 
                    }
                }
            }
        }
        return schedules;
    }

    @Override
    public List<GeneratedShiftSchedule> getByDate(LocalDate date) {
        return scheduleRepo.findByShiftDate(date);
    }
}