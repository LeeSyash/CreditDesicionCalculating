package com.moskot.testTask.services.interfaces;

import java.time.LocalDate;

public interface IDatesService {
    int getFullAge(LocalDate dateBirthday);

    LocalDate parseLocalDateFromString(String date);
    int getFullAge(String dateBirthday);
}
