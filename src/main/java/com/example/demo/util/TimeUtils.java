package com.example.demo.util;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class TimeUtils {
    // Test 50: Calculate minutes between two times 
    public static long minutesBetween(LocalTime start, LocalTime end) {
        return ChronoUnit.MINUTES.between(start, end);
    }
}