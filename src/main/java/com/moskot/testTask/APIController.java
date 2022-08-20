package com.moskot.testTask;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIController {

    @PostMapping(value="/calculateLimit")
    public ResponseEntity<String> calculateLimit(@RequestBody Client client) {
        if (client.checkRequiredParams()) {
            return new ResponseEntity<>("Required params: idClient,dateBirthday,phone,monthSalary,CurrSalary,requestLimit", HttpStatus.BAD_REQUEST);
        }
        ClientCalculator clientCalculator = new ClientCalculator();
        clientCalculator.setClient(client);
        clientCalculator.calculateLimit();
        return ResponseEntity.ok("OK");
    }

}
