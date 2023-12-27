package com.bootcamp.cuenta.businees.impl;

import com.bootcamp.cuenta.Repository.CuentaRepository;
import com.bootcamp.cuenta.Repository.entities.CuentaEntity;
import com.bootcamp.cuenta.businees.CuentaService;
import com.bootcamp.cuenta.events.CuentaCreatedEvent;
import com.bootcamp.cuenta.events.Event;
import com.bootcamp.cuenta.events.EventType;
import com.bootcamp.cuenta.model.entity.Cuenta;
import com.bootcamp.cuenta.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.UUID;

@Service
public class CuentaServiceImpl implements CuentaService {

    @Autowired
    private KafkaTemplate<String, Event<?>> producer;

    @Value("${topic.cuenta.name:cuentas}")
    private String topicCustomer;
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
        if(Utils.validarHorario()){
            Mono<Cuenta> cuenta1 = cuentaRepository.save(new CuentaEntity().toCuentaEntity(cuenta))
                    .map(CuentaEntity::toCuenta);

            CuentaCreatedEvent created = new CuentaCreatedEvent();
            created.setData(cuenta);
            created.setId(UUID.randomUUID().toString());
            created.setType(EventType.CREATED);
            created.setDate(new Date());
            this.producer.send(topicCustomer, created);
            return cuenta1;

        }else{
            Mono<Cuenta> cuenta2=null;
            return cuenta2;
        }
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
