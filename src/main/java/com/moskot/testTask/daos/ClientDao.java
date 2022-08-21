package com.moskot.testTask.daos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "client")
@Getter
@Setter
public class ClientDao {
    @Id
    @Column(name = "idClient", nullable = false)
    private Integer idClient;
    @Id
    @Column(name = "dateCurr", nullable = false)
    @CreatedDate
    private Date dateCurr;
    @Column(name = "phone")
    private String phone;
    @Column(name = "mail")
    private String mail;
    @Column(name = "address")
    private String address;
    @Column(name = "monthSalary")
    private Double monthSalary;
    @Column(name = "CurrSalary", length = 3)
    private String CurrSalary;
    @Column(name = "decision")
    private String decision;
    @Column(name = "limitItog")
    private Double limitItog;

    public ClientDao() {
    }

    public ClientDao(Integer idClient, String phone, String mail, String address, Double monthSalary, String CurrSalary, String decision, Double limitItog) {
        this.idClient = idClient;
        this.phone = phone;
        this.mail = mail;
        this.address = address;
        this.monthSalary = monthSalary;
        this.CurrSalary = CurrSalary;
        this.decision = decision;
        this.limitItog = limitItog;
    }


}
