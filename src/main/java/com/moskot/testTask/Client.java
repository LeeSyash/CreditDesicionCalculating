package com.moskot.testTask;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
public class Client {
    private Integer idClient;
    private String dateBirthday;
    private String phone;
    private String mail;
    private String address;
    private Double monthSalary;
    private String CurrSalary;
    private Double requestLimit;
    private Double monthSalaryNationalCurr;

    public Client(Integer idClient, String dateBirthday, String phone, String mail, String address, Double monthSalary, String CurrSalary, Double requestLimit) {
        this.idClient = idClient;
        this.dateBirthday = dateBirthday;
        this.phone = phone;
        this.mail = mail;
        this.address = address;
        this.monthSalary = monthSalary;
        this.CurrSalary = CurrSalary;
        this.requestLimit = requestLimit;
        if (CurrSalary.equals("UAH")) {
            monthSalaryNationalCurr = monthSalary;
        }
    }

    public boolean checkRequiredParams() {
        return idClient == null || monthSalary == null || CurrSalary == null || phone == null || dateBirthday == null;
    }

    public void calcMonthSalaryNationalCurr(float currency) {

    }

    public int getFullAge() {
        return 0;
    }
}
