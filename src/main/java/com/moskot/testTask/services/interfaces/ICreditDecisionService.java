package com.moskot.testTask.services.interfaces;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.moskot.testTask.dtos.ClientDto;
import com.moskot.testTask.exceptions.CurrencyNotFoundException;

public interface ICreditDecisionService {
    void calculateDecision(ClientDto clientDto) throws JsonProcessingException, CurrencyNotFoundException;
}
