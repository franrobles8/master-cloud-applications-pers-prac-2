package com.mastercloudapps.airport.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
@ToString
@MappedSuperclass
public class Trabajador {

    @Id
    private long id;
    
    @Column(name="cod_empleado",unique = true)
    private String codEmpleado;
    
    private String nombre;
    
    private String apellidos;
    
    private String empresa;
}
