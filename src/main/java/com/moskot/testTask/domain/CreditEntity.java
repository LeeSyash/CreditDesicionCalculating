package com.moskot.testTask.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "credit")
@Getter
@Setter
public class CreditEntity {
    @Id
    @Column(name = "idClient", nullable = false)
    private Integer idClient;
    @Id
    @Column(name = "idCredit", nullable = false)
    private Integer idCredit;
    @Column(name = "amtCredit", nullable = false)
    private Double amtCredit;
    @Column(name = "dateStart", nullable = false)
    private Date dateStart;
    @Column(name = "stateCredit", nullable = false)
    private Character stateCredit;

}
