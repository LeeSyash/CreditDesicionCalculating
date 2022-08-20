package com.moskot.testTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

public class ClientController {
    private Client client;
    private HttpRequestController httpRequestController;
    private DBAdapter dbAdapter;

    @Async
    public void calculateLimit(){
        String currency = client.getCurrSalary();
        if (!currency.equals("UAH")) {
            float currencyExchange = httpRequestController.getCurrencyExchange();
            client.calcMonthSalaryNationalCurr(currencyExchange);
        }
        Double openLoanSum = dbAdapter.getOpenLoanSum(client.getIdClient());
        double limitItog = 0.0;
//        if (client.getFullAge() >= 18 && ) {
//            limitItog = calculateK(client.getPhone()) * (client.getMonthSalaryNationalCurr() - openLoanSum);
//
//        }
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
