package com.moskot.testTask.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.moskot.testTask.dtos.ClientDto;
import com.moskot.testTask.exceptions.CurrencyNotFoundException;
import com.moskot.testTask.services.CreditDecisionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class CreditsController {
    private final CreditDecisionService creditDecisionService;

    @Autowired
    public CreditsController(CreditDecisionService creditDecisionService) {
        this.creditDecisionService = creditDecisionService;
    }

    @PostMapping(path = "/credits/calculateCreditDecision", consumes = "application/json")
    public ResponseEntity calculateLimit(@Validated @RequestBody ClientDto clientDto) throws JsonProcessingException, CurrencyNotFoundException {
        log.info("/credits/calculateCreditDecision Received request. Body: {}", clientDto);
        creditDecisionService.calculateDecision(clientDto);
        return new ResponseEntity(HttpStatus.OK);
    }

}
