package com.moskot.testTask;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@ToString
@Getter
public class Client {
    @Id
    private Integer idClient;
    private String dateBirthday;
    private String phone;
    private String mail;
    private String address;
    private Double monthSalary;
    private String CurrSalary;
    private Double requestLimit;
    @Setter
    private Double monthSalaryNationalCurr;
    @Setter
    private Double limitItog;
    @Setter
    private String decision;

    public Client(Integer idClient, String dateBirthday, String phone, String mail, String address, Double monthSalary, String CurrSalary, Double requestLimit) {
        this.idClient = idClient;
        this.dateBirthday = dateBirthday;
        this.phone = phone;
        this.mail = mail;
        this.address = address;
        this.monthSalary = monthSalary;
        this.CurrSalary = CurrSalary;
        this.requestLimit = requestLimit;
    }

    public boolean checkRequiredParams() {
        return idClient == null || monthSalary == null || CurrSalary == null || phone == null || dateBirthday == null;
    }


}
