package com.moskot.testTask.services.interfaces;

import com.moskot.testTask.domain.CreditEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICreditRepository extends CrudRepository<CreditEntity,Integer> {

    @Query("SELECT SUM(creditDao.getAmtCredit) FROM CreditDao creditDao WHERE creditDao.getIdClient = ?1 AND creditDao.getStateCredit = \"O\"")
    public Double getSumOpenCredits(Integer idClient);
}
