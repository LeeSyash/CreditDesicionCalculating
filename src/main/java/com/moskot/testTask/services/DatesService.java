package com.moskot.testTask.services;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@Service
public class DatesService {

    public int getFullAge(LocalDate dateBirthday) {
        LocalDate current = LocalDate.now();
        return Period.between(dateBirthday,current).getYears();
    }

    public LocalDate parseLocalDateFromString(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(date,formatter);
    }
}
