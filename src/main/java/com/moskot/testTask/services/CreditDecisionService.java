package com.moskot.testTask.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.moskot.testTask.domain.ClientEntity;
import com.moskot.testTask.services.interfaces.IClientRepository;
import com.moskot.testTask.services.interfaces.ICreditRepository;
import com.moskot.testTask.dtos.ClientDto;
import com.moskot.testTask.enums.MobileOperators;
import com.moskot.testTask.exceptions.CurrencyNotFoundException;
import com.moskot.testTask.services.interfaces.ICreditDecisionService;
import com.moskot.testTask.services.interfaces.ICurrencyExchangeService;
import com.moskot.testTask.services.interfaces.IDatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditDecisionService implements ICreditDecisionService {

    private final ICurrencyExchangeService currencyExchangeService;
    private final IClientRepository clientRepository;
    private final ICreditRepository creditRepository;
    private final IDatesService datesService;

    @Autowired
    public CreditDecisionService(ICurrencyExchangeService currencyExchangeService, IClientRepository clientRepository, ICreditRepository creditRepository, IDatesService datesService) {
        this.currencyExchangeService = currencyExchangeService;
        this.clientRepository = clientRepository;
        this.creditRepository = creditRepository;
        this.datesService = datesService;
    }

    @Override
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
        ClientEntity clientEntity = new ClientEntity(
                clientDto.getIdClient(),
                clientDto.getPhone(),
                clientDto.getMail(),
                clientDto.getAddress(),
                clientDto.getMonthSalary(),
                clientDto.getCurrSalary(),
                (limitItog > 0) ? "accept" : "decline",
                limitItog
        );
        clientRepository.save(clientEntity);
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
