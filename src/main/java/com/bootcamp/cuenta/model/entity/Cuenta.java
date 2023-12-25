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
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class Cuenta {
    @Id
    private String id;
    private String tipoCuenta;
    private String numeroCuenta;
    private String cci;
    private String tipoMoneda;
    private String saldo;
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String fechaApertura;
    private String clienteId;
    //private Tarjeta tarjeta;
}
