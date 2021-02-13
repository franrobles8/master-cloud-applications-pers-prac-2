package com.mastercloudapps.airport.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name="Avion")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Avion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String matricula;

    private String fabricante;

    private String modelo;

    private Double horasVuelo;

    @OneToMany(mappedBy = "avion")
    @ToString.Exclude
    private List<Revision> revisiones;

}
