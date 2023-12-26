package com.bootcamp.cuenta.controller;

import com.bootcamp.cuenta.businees.CuentaService;
import com.bootcamp.cuenta.infrastructure.controller.CuentaController;
import com.bootcamp.cuenta.model.entity.Cuenta;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.Date;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebFluxTest(CuentaController.class)
class CuentaControllerTest {
    @Autowired
    private WebTestClient webTestClient;
    @MockBean
    private CuentaService cuentaService;

    @Test
    void findAll(){
        when(cuentaService.findAll()).thenReturn(Flux.just(getCuenta()));
        webTestClient.get()
                .uri("/cuenta/findAll")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Cuenta.class)
                .hasSize(1)
                .contains();
    }

    @Test
    void save(){
        when(cuentaService.create(getCuenta())).thenReturn(Mono.just(getCuenta()));
        webTestClient.post()
                .uri("/cuenta/save")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(getCuenta())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Cuenta.class)
                .hasSize(0)
                .contains();
    }

    @Test
    void findAllBy(){
        when(cuentaService.findAllBy("1")).thenReturn(Mono.just(getCuenta()));
        webTestClient.get()
                .uri("/cuenta/findAllBy?id=1")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Cuenta.class)
                .hasSize(1)
                .contains();
    }

    @Test
    void update(){
        when(cuentaService.update(getCuenta())).thenReturn(Mono.just(getCuenta()));
        webTestClient.put()
                .uri("/cuenta/update")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(getCuenta())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Cuenta.class)
                .hasSize(0)
                .contains();
    }

    @Test
    void deleteById() {
        when(cuentaService.deleteById("1")).thenReturn(Mono.empty());
        webTestClient.delete()
                .uri("/cuenta/delete?id=1")
                .exchange()
                .expectStatus().isOk()
                .expectBody().isEmpty();
    }

    public Cuenta getCuenta(){
        return new Cuenta("185452","Debito","85471238745456","activo"
                ,"74574121234568456688","soles", new BigDecimal(2220.00),new Date(1994,03,17),"12453");
    }
}
