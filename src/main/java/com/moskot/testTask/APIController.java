package com.moskot.testTask;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIController {

    @PostMapping(value="/calculateLimit"/*, params="idClient,dateBirthday,phone,mail,address,monthSalary,CurrSalary,requestLimit"*/)
    public ResponseEntity<String> calculateLimit(@RequestBody Client client) {
        System.out.println(client.toString());
        if (client.checkRequiredParams()) {
            return new ResponseEntity<>("Required params: idClient,dateBirthday,phone,monthSalary,CurrSalary,requestLimit", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

}
