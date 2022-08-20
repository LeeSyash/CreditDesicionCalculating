package com.moskot.testTask;

import lombok.Setter;
import org.springframework.scheduling.annotation.Async;

public class ClientCalculator {
    @Setter
    private Client client;
    private HttpRequestController httpRequestController;
    private DBAdapter dbAdapter;

    public void calculateLimit() {
        calcMonthSalaryNationalCurr();
        double limitItog = 0.0;
        if (getFullAge() >= 18) {
            Double openLoanSum = dbAdapter.getOpenLoanSum(client.getIdClient());
            if (openLoanSum < (0.6 * client.getMonthSalaryNationalCurr())) {
                limitItog = calculateK(client.getPhone()) * (client.getMonthSalaryNationalCurr() - openLoanSum);
            }
        }
        limitItog = (limitItog > client.getRequestLimit()) ? client.getRequestLimit() : limitItog;
        client.setLimitItog(limitItog);
        client.setDecision((limitItog > 0) ? "accept" : "decline");
        dbAdapter.insertLimitDecision(client);
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

    private void calcMonthSalaryNationalCurr() {
        if (client.getCurrSalary().equals("UAH")) {
            client.setMonthSalaryNationalCurr(client.getMonthSalary());
        } else {
            float currencyExchange = httpRequestController.getCurrencyExchange();
            client.setMonthSalaryNationalCurr(client.getMonthSalary() * currencyExchange);
        }
    }

    private int getFullAge() {
        return 0;
    }
}
