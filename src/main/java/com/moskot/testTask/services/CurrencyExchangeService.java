package com.moskot.testTask.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.moskot.testTask.dtos.CurrencyExchangeDto;
import com.moskot.testTask.exceptions.CurrencyNotFoundException;
import com.moskot.testTask.services.interfaces.ICurrencyExchangeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@Service
public class CurrencyExchangeService implements ICurrencyExchangeService {

    @Override
    public Double getAmountInNationalCurr(Double amount, String currency) throws JsonProcessingException, CurrencyNotFoundException {
        if (currency.equals("UAH")) {
            return amount;
        }
        float currencyExchange = getSaleRate(currency);
        log.debug("Currency exchange amount {} at the rate {}", amount, currencyExchange);
        return amount * currencyExchange;
    }

    @Override
    public float getSaleRate(String currency) throws JsonProcessingException, CurrencyNotFoundException {
        return getCurrencyExchange(currency).getFloatSale();
    }

    @Override
    public float getBuyRate(String currency) throws JsonProcessingException {
        return getCurrencyExchange(currency).getFloatBuy();
    }
    @Override
    public CurrencyExchangeDto getCurrencyExchange(String currency) throws JsonProcessingException, CurrencyNotFoundException {
        List<CurrencyExchangeDto> currencyExchangeRates = getCurrencyExchanges(currency);
        for (CurrencyExchangeDto currencyExchange:
                currencyExchangeRates) {
            if (currencyExchange.getCcy().equals(currency)) {
                return currencyExchange;
            }
        }
        throw new CurrencyNotFoundException("Currency exchange rates for " + currency + " doesn`t exist");
    }
    @Override
    public List<CurrencyExchangeDto> getCurrencyExchanges(String currency) throws JsonProcessingException, CurrencyNotFoundException {
        final String uri = "https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5";

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        List<CurrencyExchangeDto> currencyExchangeRates = objectMapper.readValue(result,new TypeReference<List<CurrencyExchangeDto>>(){});
        log.debug(currencyExchangeRates.stream().map(CurrencyExchangeDto::toString).reduce("", String::concat));
        return currencyExchangeRates;
    }
}
