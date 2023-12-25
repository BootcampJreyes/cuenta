package com.bootcamp.cuenta.businees.impl;

import com.bootcamp.cuenta.Repository.CuentaRepository;
import com.bootcamp.cuenta.Repository.entities.CuentaEntity;
import com.bootcamp.cuenta.businees.CuentaService;
import com.bootcamp.cuenta.model.entity.Cuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CuentaServiceImpl implements CuentaService {
    @Autowired
    private CuentaRepository cuentaRepository;

    @Override
    public Flux<Cuenta> findAll() {
        return this.cuentaRepository
                .findAll()
                .map(CuentaEntity::toCuenta);
    }

    @Override
    public Mono<Cuenta> create(Cuenta cuenta) {
        return cuentaRepository.save(new CuentaEntity().toCuentaEntity(cuenta))
                .map(CuentaEntity::toCuenta);
    }

    @Override
    public Mono<Cuenta> findAllBy(String id){
        return cuentaRepository.findById(id)
                .map(CuentaEntity::toCuenta);
    }
    @Override
    public Mono<Cuenta> update(Cuenta cuenta){
        return cuentaRepository.save(new CuentaEntity().toCuentaEntity(cuenta))
                .map(CuentaEntity::toCuenta);
    }
    @Override
    public Mono<Void> deleteById(String id){
        return cuentaRepository.deleteById(id);
    }
}
