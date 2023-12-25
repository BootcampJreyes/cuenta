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
    private String dni;
    private String nombre;
    private String apellido;
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String fechaNacimiento;
    private String celular;
    private String email;
    private String ciudad;



}
