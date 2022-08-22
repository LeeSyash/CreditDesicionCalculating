package com.moskot.testTask.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "credit")
@Getter @Setter
@IdClass(CreditEntity.class)
public class CreditEntity implements Serializable {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreditEntity that = (CreditEntity) o;
        return idClient.equals(that.idClient) && idCredit.equals(that.idCredit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idClient, idCredit);
    }

}
