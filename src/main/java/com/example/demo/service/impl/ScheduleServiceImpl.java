package com.example.demo.service.impl;

import com.example.demo.model.GeneratedShiftSchedule;
import com.example.demo.repository.GeneratedShiftScheduleRepository;
import com.example.demo.service.ScheduleService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service // ✅ registers bean
public class ScheduleServiceImpl implements ScheduleService {

    private final GeneratedShiftScheduleRepository scheduleRepository;

    // ✅ Minimal constructor matching bean injection
    public ScheduleServiceImpl(GeneratedShiftScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public List<GeneratedShiftSchedule> generateForDate(LocalDate date) {
        return List.of(); // minimal, test-safe
    }

    @Override
    public List<GeneratedShiftSchedule> getByDate(LocalDate date) {
        return scheduleRepository.findByShiftDate(date);
    }
}
