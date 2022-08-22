package com.moskot.testTask.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.IdClass;
import java.io.Serializable;
import java.util.Objects;

@Getter @Setter @ToString
@IdClass(CreditPK.class)
public class CreditPK implements Serializable {
    private Integer idClient;
    private Integer idCredit;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreditPK creditPK = (CreditPK) o;
        return idClient.equals(creditPK.idClient) && idCredit.equals(creditPK.idCredit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idClient, idCredit);
    }
}
