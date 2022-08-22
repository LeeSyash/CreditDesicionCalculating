package com.moskot.testTask.services;

import com.moskot.testTask.services.interfaces.IDatesService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@Service
public class DatesService implements IDatesService {

    @Override
    public int getFullAge(LocalDate dateBirthday) {
        LocalDate current = LocalDate.now();
        return Period.between(dateBirthday,current).getYears();
    }

    @Override
    public LocalDate parseLocalDateFromString(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(date,formatter);
    }
}
