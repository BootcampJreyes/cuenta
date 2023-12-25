package com.bootcamp.cuenta.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class Tarjeta {
    @Id
    private String id;
    private String numeroTarjeta;
    private String fechaCaducidad;
    private String estadoTarjeta;
}
