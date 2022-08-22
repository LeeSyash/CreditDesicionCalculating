package com.moskot.testTask.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.IdClass;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Getter @Setter @ToString
@IdClass(ClientPK.class)
public class ClientPK implements Serializable {
    private Integer idClient;
    private Date dateCurr;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientPK clientPK = (ClientPK) o;
        return idClient.equals(clientPK.idClient) && dateCurr.equals(clientPK.dateCurr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idClient, dateCurr);
    }
}
