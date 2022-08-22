package com.moskot.testTask.services.interfaces;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.moskot.testTask.exceptions.CurrencyNotFoundException;

public interface ICurrencyExchangeService {
    Double getAmountInNationalCurr(Double amount, String currency) throws JsonProcessingException, CurrencyNotFoundException;

    float getSaleRate(String currency) throws JsonProcessingException, CurrencyNotFoundException;

    float getBuyRate(String currency) throws JsonProcessingException;
}
