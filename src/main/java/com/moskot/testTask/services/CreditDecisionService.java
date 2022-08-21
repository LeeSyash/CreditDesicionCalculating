package com.moskot.testTask.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.moskot.testTask.daos.ClientDao;
import com.moskot.testTask.daos.ClientRepository;
import com.moskot.testTask.daos.CreditRepository;
import com.moskot.testTask.dtos.ClientDto;
import com.moskot.testTask.enums.MobileOperators;
import com.moskot.testTask.exceptions.CurrencyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditDecisionService {

    @Autowired
    private CurrencyExchangeService currencyExchangeService;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private CreditRepository creditRepository;
    @Autowired
    private DatesService datesService;

    public void calculateDecision(ClientDto clientDto) throws JsonProcessingException, CurrencyNotFoundException {
        Double monthSalaryNationalCurr = currencyExchangeService.getAmountInNationalCurr(clientDto.getMonthSalary(), clientDto.getCurrSalary());
        Double limitItog = 0d;
        int fullAge = datesService.getFullAge(datesService.parseLocalDateFromString(clientDto.getDateBirthday()));
        if (fullAge >= 18) {
            Double openCreditsAmount = creditRepository.getSumOpenCredits(clientDto.getIdClient());
            if (openCreditsAmount < (0.6 * monthSalaryNationalCurr)) {
                limitItog = calculateK(clientDto.getPhone()) * (monthSalaryNationalCurr - openCreditsAmount);
                limitItog = (limitItog > clientDto.getRequestLimit()) ? clientDto.getRequestLimit() : limitItog;
            }
        }
        ClientDao clientDao = new ClientDao(
                clientDto.getIdClient(),
                clientDto.getPhone(),
                clientDto.getMail(),
                clientDto.getAddress(),
                clientDto.getMonthSalary(),
                clientDto.getCurrSalary(),
                (limitItog > 0) ? "accept" : "decline",
                limitItog
        );
        clientRepository.save(clientDao);
    }

    private float calculateK(String phone) {
        String clientPhoneCode = phone.substring(phone.length() - 7).substring(0, phone.length() - 10);
        if (MobileOperators.KYIVSTAR.getCodes().contains(clientPhoneCode)) {
            return MobileOperators.KYIVSTAR.getK();
        }
        if (MobileOperators.VODAFONE.getCodes().contains(clientPhoneCode)) {
            return MobileOperators.VODAFONE.getK();
        }
        if (MobileOperators.LIFE.getCodes().contains(clientPhoneCode)) {
            return MobileOperators.LIFE.getK();
        }
        return MobileOperators.OTHER.getK();
    }
}
