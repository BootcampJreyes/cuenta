package com.bootcamp.cuenta.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class Cuenta {
    @Id
    private String id;
    private String tipoCuenta;
    private String numeroCuenta;
    private String estadoCuenta;
    private String cci;
    private String tipoMoneda;
    private BigDecimal saldo;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaApertura;
    private String clienteId;
}
