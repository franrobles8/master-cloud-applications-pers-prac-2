package com.mastercloudapps.airport.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="Aeropuerto")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Aeropuerto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 3)
    private String codIATA;

    private String nombre;

    private String ciudad;

    private String pais;

}
