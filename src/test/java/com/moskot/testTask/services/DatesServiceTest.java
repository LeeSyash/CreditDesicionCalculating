package com.moskot.testTask.services;

import com.moskot.testTask.services.interfaces.IDatesService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class DatesServiceTest {
    @Mock
    private static IDatesService datesService;

    @Test
    public void getFullAge_Less18() {
        int age = datesService.getFullAge("2021-07-01");

        assertThat(age == 1);
    }

    @Test
    public void getFull_Age18() {
        int age = datesService.getFullAge("2004-07-01");

        assertThat(age == 18);
    }

    @Test
    public void getFullAge_More18() {
        int age = datesService.getFullAge("2003-07-01");

        assertThat(age == 19);
    }
}