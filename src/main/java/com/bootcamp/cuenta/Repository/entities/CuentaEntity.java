package com.bootcamp.cuenta.Repository.entities;

import com.bootcamp.cuenta.model.entity.Cuenta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
@Document(collection = "cuenta")
public class CuentaEntity {
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

    public CuentaEntity() {

    }
    public CuentaEntity toCuentaEntity(Cuenta cuenta) {
        CuentaEntity cuentaEntity = CuentaEntity.builder().build();
        BeanUtils.copyProperties(cuenta, cuentaEntity);
        return cuentaEntity;
    }
    public Cuenta toCuenta() {
        Cuenta cuenta = Cuenta.builder().build();
        BeanUtils.copyProperties( this, cuenta);
        return cuenta;
    }
}
