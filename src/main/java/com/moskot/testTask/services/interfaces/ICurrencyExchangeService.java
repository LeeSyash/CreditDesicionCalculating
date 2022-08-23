package com.moskot.testTask.services.interfaces;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.moskot.testTask.dtos.CurrencyExchangeDto;
import com.moskot.testTask.exceptions.CurrencyNotFoundException;

import java.util.List;

public interface ICurrencyExchangeService {
    Double getAmountInNationalCurr(Double amount, String currency) throws JsonProcessingException, CurrencyNotFoundException;

    float getSaleRate(String currency) throws JsonProcessingException, CurrencyNotFoundException;

    float getBuyRate(String currency) throws JsonProcessingException;

    CurrencyExchangeDto getCurrencyExchange(String currency) throws JsonProcessingException, CurrencyNotFoundException;

    List<CurrencyExchangeDto> getCurrencyExchanges() throws JsonProcessingException, CurrencyNotFoundException;
}
