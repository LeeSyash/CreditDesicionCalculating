package com.moskot.testTask.handlers;

import com.moskot.testTask.exceptions.CurrencyNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CreditDecisionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CurrencyNotFoundException.class)
    public ResponseEntity handleCurrencyNotFoundException(Exception e, WebRequest request) {
        return handleExceptionInternal(e, e.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
