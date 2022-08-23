package com.moskot.testTask.services;

import com.moskot.testTask.services.interfaces.IClientRepository;
import com.moskot.testTask.services.interfaces.ICreditRepository;
import com.moskot.testTask.services.interfaces.ICurrencyExchangeService;
import com.moskot.testTask.services.interfaces.IDatesService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class CreditDecisionServiceTest {

    @Mock
    private IClientRepository clientRepository;

    @Mock
    private ICreditRepository creditRepository;

    @Mock
    private ICurrencyExchangeService currencyExchangeService;

    @Mock
    private IDatesService datesService;


    @Test
    public void calculateK_format1() {
        CreditDecisionService creditDecisionService = new CreditDecisionService(currencyExchangeService,clientRepository,creditRepository,datesService);
        float k = creditDecisionService.calculateK("+380990365423");
        assertThat(k == 0.94f);
    }

    @Test
    public void calculateK_format2() {
        CreditDecisionService creditDecisionService = new CreditDecisionService(currencyExchangeService,clientRepository,creditRepository,datesService);
        float k = creditDecisionService.calculateK("0990365423");
        assertThat(k == 0.94f);
    }

    @Test
    public void calculateK_notRealPhoneNumber() {
        CreditDecisionService creditDecisionService = new CreditDecisionService(currencyExchangeService,clientRepository,creditRepository,datesService);
        float k = creditDecisionService.calculateK("1234567891011");
        assertThat(k == 0.90f);
    }

//    @Test
//    public void test_calculateCreditDecision() {
//        MockHttpServletRequest request = new MockHttpServletRequest();
//        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
//
//        Double openCreditAmount = 2300d;
//        when(creditRepository.getSumOpenCredits(any(Integer.class))).thenReturn(openCreditAmount);
//
//        ClientDto clientDto = new ClientDto();
//        clientDto.setIdClient(123456);
//        clientDto.setDateBirthday("1995-08-01");
//        clientDto.setPhone("+380990365423");
//        clientDto.setMonthSalary(120000d);
//        clientDto.setCurrSalary("UAH");
//        clientDto.setRequestLimit(150000d);
//
//
//
//    }

}