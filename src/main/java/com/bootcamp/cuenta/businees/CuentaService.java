package com.bootcamp.cuenta.businees;

import com.bootcamp.cuenta.model.entity.Cuenta;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface CuentaService {
    Flux<Cuenta> findAll();

    Mono<Cuenta> create(Cuenta cuenta);

    Mono<Cuenta> findAllBy(String id);
    Mono<Cuenta> update(Cuenta Cuenta);
    Mono<Void> deleteById(String id);

}
