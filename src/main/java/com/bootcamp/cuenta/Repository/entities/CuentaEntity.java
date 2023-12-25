package com.bootcamp.cuenta.Repository.entities;

import com.bootcamp.cuenta.model.entity.Cuenta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Getter
@Setter
@AllArgsConstructor
@Document(collection = "cuenta")
public class CuentaEntity {
    @Id
    private String id;
    private String dni;
    private String nombre;
    private String apellido;
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String fechaNacimiento;
    private String celular;
    private String email;
    private String ciudad;

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
