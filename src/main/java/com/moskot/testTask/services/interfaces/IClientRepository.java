package com.moskot.testTask.services.interfaces;

import com.moskot.testTask.domain.ClientEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientRepository extends CrudRepository<ClientEntity,Integer> {
}
