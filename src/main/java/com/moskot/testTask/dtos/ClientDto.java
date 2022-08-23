package com.moskot.testTask.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter @Setter
@ToString
public class ClientDto {
    @NotNull
    private Integer idClient;
    @NotNull
    private String dateBirthday;
    @NotNull
    private String phone;
    private String mail;
    private String address;
    @NotNull
    private Double monthSalary;
    @NotNull
    private String CurrSalary;
    private Double requestLimit;

    public ClientDto(int idClient, String dateBirthday, String phone, String mail, String address, Double monthSalary, String CurrSalary, Double requestLimit) {
        this.idClient = idClient;
        this.dateBirthday = dateBirthday;
        this.phone = phone;
        this.mail = mail;
        this.address = address;
        this.monthSalary = monthSalary;
        this.CurrSalary = CurrSalary;
        this.requestLimit = requestLimit;
    }

    public ClientDto() {
    }
}
