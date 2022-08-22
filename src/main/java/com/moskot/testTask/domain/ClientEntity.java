package com.moskot.testTask.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "client")
@Getter @Setter @ToString
@IdClass(ClientEntity.class)
public class ClientEntity implements Serializable {
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

    public ClientEntity() {
    }

    public ClientEntity(Integer idClient, String phone, String mail, String address, Double monthSalary, String CurrSalary, String decision, Double limitItog) {
        this.idClient = idClient;
        this.phone = phone;
        this.mail = mail;
        this.address = address;
        this.monthSalary = monthSalary;
        this.CurrSalary = CurrSalary;
        this.decision = decision;
        this.limitItog = limitItog;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientEntity that = (ClientEntity) o;
        return idClient.equals(that.idClient) && dateCurr.equals(that.dateCurr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idClient, dateCurr);
    }
}
