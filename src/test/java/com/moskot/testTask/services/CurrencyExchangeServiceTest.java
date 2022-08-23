package com.moskot.testTask.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.moskot.testTask.dtos.CurrencyExchangeDto;
import com.moskot.testTask.exceptions.CurrencyNotFoundException;
import com.moskot.testTask.services.interfaces.ICurrencyExchangeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CurrencyExchangeServiceTest {

    @Mock
    private ICurrencyExchangeService currencyExchangeService;

    @Test
    public void getSaleRate_returnSale() throws JsonProcessingException, CurrencyNotFoundException {
        CurrencyExchangeDto currencyExchangeDto = new CurrencyExchangeDto("USD","UAH","38.90000","39.90000");
        float currencyRate = currencyExchangeService.getSaleRate("USD");

        assertThat(currencyRate == 39.90000);
    }
}