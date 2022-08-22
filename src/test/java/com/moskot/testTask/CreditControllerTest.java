package com.moskot.testTask;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.moskot.testTask.controllers.CreditsController;
import com.moskot.testTask.dtos.ClientDto;
import com.moskot.testTask.services.CreditDecisionService;
import com.moskot.testTask.services.CurrencyExchangeService;
import com.moskot.testTask.services.DatesService;
import com.moskot.testTask.services.interfaces.IClientRepository;
import com.moskot.testTask.services.interfaces.ICreditRepository;
import com.moskot.testTask.services.interfaces.ICurrencyExchangeService;
import com.moskot.testTask.services.interfaces.IDatesService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreditControllerTest {
    @InjectMocks
    private CreditsController creditsController;

    @Mock
    private IClientRepository clientRepository;

    @Mock
    private ICreditRepository creditRepository;

    @Mock
    private ICurrencyExchangeService currencyExchangeService;

    @Mock
    private IDatesService datesService;

    @Test
    public void test_calculateCreditDecision() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        Double openCreditAmount = 2300d;
        when(creditRepository.getSumOpenCredits(any(Integer.class))).thenReturn(openCreditAmount);

        ClientDto clientDto = new ClientDto();
        clientDto.setIdClient(123456);
        clientDto.setDateBirthday("1995-08-01");
        clientDto.setPhone("+380990365423");
        clientDto.setMonthSalary(120000d);
        clientDto.setCurrSalary("UAH");
        clientDto.setRequestLimit(150000d);


    }

    @Test
    public void test_CurrencyExchangeService_getSaleRate_USD() {
        ICurrencyExchangeService currencyExchangeService = new CurrencyExchangeService();
        float currencyRate;
        try {
            currencyRate = currencyExchangeService.getSaleRate("USD");
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        assertThat(currencyRate == 39.90000);
    }

    @Test
    public void test_DatesService_getFullAge_Less18() {
        IDatesService datesService = new DatesService();
        int age = datesService.getFullAge("2021-07-01");

        assertThat(age == 1);
    }

    @Test
    public void test_DatesService_getFull_Age18() {
        IDatesService datesService = new DatesService();
        int age = datesService.getFullAge("2004-07-01");

        assertThat(age == 18);
    }

    @Test
    public void test_DatesService_getFullAge_More18() {
        IDatesService datesService = new DatesService();
        int age = datesService.getFullAge("2003-07-01");

        assertThat(age == 19);
    }

    @Test
    public void test_CreditDecisionService_calculateK_format1() {
        CreditDecisionService creditDecisionService = new CreditDecisionService(currencyExchangeService,clientRepository,creditRepository,datesService);
        float k = creditDecisionService.calculateK("+380990365423");
        assertThat(k == 0.94F);
    }

    @Test
    public void test_CreditDecisionService_calculateK_format2() {
        CreditDecisionService creditDecisionService = new CreditDecisionService(currencyExchangeService,clientRepository,creditRepository,datesService);
        float k = creditDecisionService.calculateK("0990365423");
        assertThat(k == 0.94F);
    }



}
