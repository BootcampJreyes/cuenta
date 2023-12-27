package com.bootcamp.cuenta.events;

import com.bootcamp.cuenta.model.entity.Cuenta;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CuentaCreatedEvent extends Event<Cuenta>{
}
