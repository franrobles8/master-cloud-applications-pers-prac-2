package com.mastercloudapps.airport.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@Builder
public class IdVueloTripulante implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -6526090005137283576L;
    
    private Long vuelo;
    private Long tripulante;
}