package com.mastercloudapps.airport.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
@ToString(callSuper=true, includeFieldNames=true)
@EqualsAndHashCode(callSuper = true)
@Entity(name="Mecanico")
public class Mecanico extends Trabajador {

    private String añoIncorporacion;
    private String formacionPrevia;
    
    @OneToMany(mappedBy = "mecanico", fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<Revision> revisiones;
}
