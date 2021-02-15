package com.mastercloudapps.airport.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
@Data
@NoArgsConstructor
public class VueloTripulante {

    @EmbeddedId
    private IdVueloTripulante id;

    @ManyToOne
    @MapsId("vuelo")
    private Vuelo vuelo;

    @ManyToOne
    @MapsId("tripulante")
    private Tripulante tripulante;

    @Builder
    public VueloTripulante(Vuelo vuelo, Tripulante tripulante) {
        this.vuelo = vuelo;
        this.tripulante = tripulante;
        this.id = new IdVueloTripulante(vuelo.getId(), tripulante.getId());
    }
}
