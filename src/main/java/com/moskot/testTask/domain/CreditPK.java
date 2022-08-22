package com.moskot.testTask.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.IdClass;
import java.io.Serializable;

@Getter @Setter
@IdClass(CreditPK.class)
public class CreditPK implements Serializable {
    private Integer idClient;
    private Integer idCredit;
}
