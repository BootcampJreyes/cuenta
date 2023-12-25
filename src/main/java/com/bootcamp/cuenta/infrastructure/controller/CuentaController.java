package com.bootcamp.cuenta.infrastructure.controller;

import com.bootcamp.cuenta.businees.CuentaService;
import com.bootcamp.cuenta.model.entity.Cuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(CuentaController.CUENTA)
public class CuentaController {
    public static final String CUENTA = "/cuenta";
    public static final String FINDALL = "/findAll";
    public static final String SAVE = "/save";
    public static final String FINDALLBY = "/findAllBy";
    public static final String UPDATE = "/update";
    public static final String DELETE = "/delete";
    @Autowired
    private CuentaService cuentaService;

    @RequestMapping(FINDALL)
    private Flux<Cuenta> findAll() {
        return cuentaService.findAll();
    }

    @PostMapping(SAVE)
    private Mono<Cuenta> create(@RequestBody Cuenta cuenta) {
        return cuentaService.create(cuenta);
    }

    @GetMapping(FINDALLBY)
    private Mono<Cuenta> findAllBy(@RequestParam("id") String id) throws Exception{
        return cuentaService.findAllBy(id);
    }

    @PutMapping(UPDATE)
    private Mono<Cuenta> update(@RequestBody Cuenta cuenta){
        return cuentaService.update(cuenta);
    }

    @DeleteMapping(DELETE)
    private Mono<Void> deleteById(@RequestParam("id") String id){
        return cuentaService.deleteById(id);
    }
}
