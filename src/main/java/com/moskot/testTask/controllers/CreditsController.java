package com.moskot.testTask.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.moskot.testTask.dtos.ClientDto;
import com.moskot.testTask.exceptions.CurrencyNotFoundException;
import com.moskot.testTask.services.CreditDecisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CreditsController {
    @Autowired
    private CreditDecisionService creditDecisionService;

    @PostMapping(path = "/credits/calculateCreditDecision", consumes = "application/json")
    public ResponseEntity calculateLimit(@Validated @RequestBody ClientDto clientDto) throws JsonProcessingException, CurrencyNotFoundException {
        creditDecisionService.calculateDecision(clientDto);
        return new ResponseEntity(HttpStatus.OK);
    }

}
