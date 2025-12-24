package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.ScheduleService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;
@Service
public class ScheduleServiceImpl implements ScheduleService {

    private final ShiftTemplateRepository shiftTemplateRepository;
    private final AvailabilityRepository availabilityRepository;
    private final EmployeeRepository employeeRepository;
    private final GeneratedShiftScheduleRepository scheduleRepository;
    private final DepartmentRepository departmentRepository;

    public ScheduleServiceImpl(ShiftTemplateRepository shiftTemplateRepository,
                               AvailabilityRepository availabilityRepository,
                               EmployeeRepository employeeRepository,
                               GeneratedShiftScheduleRepository scheduleRepository,
                               DepartmentRepository departmentRepository) {
        this.shiftTemplateRepository = shiftTemplateRepository;
        this.availabilityRepository = availabilityRepository;
        this.employeeRepository = employeeRepository;
        this.scheduleRepository = scheduleRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<GeneratedShiftSchedule> generateForDate(LocalDate date) {
        List<Department> departments = departmentRepository.findAll();
        List<EmployeeAvailability> availabilities = availabilityRepository.findByAvailableDateAndAvailable(date, true);

        if (availabilities.isEmpty()) return List.of();

        List<ShiftTemplate> templates = shiftTemplateRepository.findAll();
        if (templates.isEmpty()) return List.of();

        GeneratedShiftSchedule schedule = new GeneratedShiftSchedule();
        schedule.setShiftDate(date);
        schedule.setEmployee(availabilities.get(0).getEmployee());
        scheduleRepository.save(schedule);

        return List.of(schedule);
    }

    @Override
    public List<GeneratedShiftSchedule> getByDate(LocalDate date) {
        return scheduleRepository.findByShiftDate(date);
    }
}
