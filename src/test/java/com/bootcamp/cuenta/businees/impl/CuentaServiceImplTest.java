package com.bootcamp.cuenta.businees.impl;

import com.bootcamp.cuenta.Repository.CuentaRepository;
import com.bootcamp.cuenta.Repository.entities.CuentaEntity;
import com.bootcamp.cuenta.model.entity.Cuenta;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.math.BigDecimal;
import java.util.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CuentaServiceImplTest {
    @Mock
    private CuentaRepository cuentaRepository;
    @InjectMocks
    private CuentaServiceImpl cuentaServiceImpl;


    @Test
    void findAll() {
        when(cuentaRepository.findAll()).thenReturn(Flux.just(getCuentaEntity()));
        when(cuentaServiceImpl.findAll()).thenReturn(Flux.just(getCuenta()));

        Flux<Cuenta> resultado = cuentaServiceImpl.findAll();
        StepVerifier.create(resultado) // Verifica que haya dos elementos en el flujo
                .expectNext(getCuenta())
                .expectComplete()
                .verify();
    }

    @Test
    void save() {
        when(cuentaRepository.save(getCuentaEntity())).thenReturn(Mono.just(getCuentaEntity()));
        when(cuentaServiceImpl.create(getCuenta())).thenReturn(Mono.just(getCuenta()));

        Mono<Cuenta> resultado = cuentaServiceImpl.create(getCuenta());

        StepVerifier.create(resultado)
                .expectNext(getCuenta())
                .expectComplete()
                .verify();
    }

    @Test
    void findAllBy() {
        when(cuentaRepository.findById(anyString())).thenReturn(Mono.just(getCuentaEntity()));
        when(cuentaServiceImpl.findAllBy(anyString())).thenReturn(Mono.just(getCuenta()));

        Mono<Cuenta> resultado = cuentaServiceImpl.findAllBy("1");

        StepVerifier.create(resultado)
                .expectNext(getCuenta())
                .expectComplete()
                .verify();
    }

    @Test
    void update() {
        when(cuentaRepository.save(any())).thenReturn(Mono.just(getCuentaEntity()));
        when(cuentaServiceImpl.update(any())).thenReturn(Mono.just(getCuenta()));

        Mono<Cuenta> resultado = cuentaServiceImpl.update(getCuenta());

        StepVerifier.create(resultado)
                .expectNext(getCuenta())
                .expectComplete()
                .verify();
    }

    @Test
    void deleteById() {
        when(cuentaRepository.deleteById(anyString())).thenReturn(Mono.empty());
        when(cuentaServiceImpl.deleteById(anyString())).thenReturn(Mono.empty());

        Mono<Void> resultado = cuentaServiceImpl.deleteById("1");

        StepVerifier.create(resultado)
                .expectComplete()
                .verify();
    }

    public CuentaEntity getCuentaEntity(){
        return new CuentaEntity("185452","Debito","85471238745456","activo"
                ,"74574121234568456688","soles", new BigDecimal(2220.00),new Date(1994,03,17),"12453");
    }
    public Cuenta getCuenta(){
        return new Cuenta("185452","Debito","85471238745456","activo"
                ,"74574121234568456688","soles", new BigDecimal(2220.00),new Date(1994,03,17),"12453");
    }
}
