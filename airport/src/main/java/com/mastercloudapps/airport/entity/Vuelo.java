package com.mastercloudapps.airport.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name="Vuelo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vuelo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String codVuelo;

    private String compania;

    @OneToOne
    private Avion avion;

    @OneToOne
    private Aeropuerto origen;

    @OneToOne
    private Aeropuerto destino;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHora;

    private Double duracion;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vuelo", orphanRemoval = true)
    @ToString.Exclude
    private List<VueloTripulante> tripulantes;

}
