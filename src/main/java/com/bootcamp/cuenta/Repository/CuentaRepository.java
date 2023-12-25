package com.bootcamp.cuenta.Repository;

import com.bootcamp.cuenta.Repository.entities.CuentaEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaRepository extends ReactiveMongoRepository<CuentaEntity, String> {

}
