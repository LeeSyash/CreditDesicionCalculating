package com.moskot.testTask.services.interfaces;

import com.moskot.testTask.domain.CreditEntity;
import com.moskot.testTask.domain.CreditPK;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICreditRepository extends CrudRepository<CreditEntity, CreditPK> {

    @Query(value = "SELECT SUM(creditDao.getAmtCredit) FROM CreditDao creditDao WHERE creditDao.getIdClient = :idClient AND creditDao.getStateCredit = 'O'", nativeQuery = true)
    Double getSumOpenCredits(@Param("idClient") Integer idClient);
}
