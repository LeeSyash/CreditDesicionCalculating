package com.moskot.testTask.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.IdClass;
import java.io.Serializable;
import java.util.Date;

@Getter @Setter
@IdClass(ClientPK.class)
public class ClientPK implements Serializable {
    private Integer idClient;
    private Date dateCurr;

}
