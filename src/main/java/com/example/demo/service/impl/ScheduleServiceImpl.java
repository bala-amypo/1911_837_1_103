package com.example.demo.service.impl;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.ScheduleService;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Service
public class ScheduleServiceImpl implements ScheduleService {
    private final DepartmentRepository departmentRepository;
    private final ShiftTemplateRepository shiftTemplateRepository;
    private final EmployeeRepository employeeRepository;
    private final AvailabilityRepository availabilityRepository;
    private final GeneratedShiftScheduleRepository scheduleRepository;
    public ScheduleServiceImpl(DepartmentRepository departmentRepository,ShiftTemplateRepository shiftTemplateRepository,EmployeeRepository employeeRepository,AvailabilityRepository availabilityRepository,GeneratedShiftScheduleRepository scheduleRepository) {
        this.departmentRepository = departmentRepository;
        this.shiftTemplateRepository = shiftTemplateRepository;
        this.employeeRepository = employeeRepository;
        this.availabilityRepository = availabilityRepository;
        this.scheduleRepository = scheduleRepository;
    }
    @Override
    public List<GeneratedShiftSchedule> generateForDate(LocalDate date) {
        List<GeneratedShiftSchedule> generatedSchedules = new ArrayList<>();
        List<Department> departments = departmentRepository.findAll();
        for (Department department : departments) {
            List<ShiftTemplate> templates = shiftTemplateRepository.findByDepartment_Id(department.getId());
            for (ShiftTemplate template : templates) {
            List<EmployeeAvailability> availabilities =
            availabilityRepository.findByAvailableDateAndAvailable(date, true);
            for (EmployeeAvailability availability : availabilities) {
            Employee employee = availability.getEmployee();
            if (employee.getSkillsList().containsAll(template.getRequiredSkillsList())) {
                    GeneratedShiftSchedule schedule = new GeneratedShiftSchedule();
                        schedule.setShiftDate(date);
                        schedule.setStartTime(template.getStartTime());
                        schedule.setEndTime(template.getEndTime());
                        schedule.setShiftTemplate(template);
                        schedule.setDepartment(department);
                        schedule.setEmployee(employee);

                        generatedSchedules.add(scheduleRepository.save(schedule));
                        break; // assign first qualified employee
                    }
                }
            }
        }
        return generatedSchedules;
    }
    @Override
    public List<GeneratedShiftSchedule> getByDate(LocalDate date) {
        return scheduleRepository.findByShiftDate(date);
    }
}
