package com.example.demo.service;
import com.example.demo.repository.GeneratedShiftScheduleRepository;
import com.example.demo.service.ScheduleService;
import com.example.demo.service.impl.ScheduleServiceImpl;
import com.example.demo.model.GeneratedShiftSchedule;
import java.time.LocalDate;
import java.util.List;

public interface ScheduleService {
    List<GeneratedShiftSchedule> generateForDate(LocalDate date);
    List<GeneratedShiftSchedule> getByDate(LocalDate date);
}
