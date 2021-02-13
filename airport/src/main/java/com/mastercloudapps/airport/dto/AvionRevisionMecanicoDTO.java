package com.mastercloudapps.airport.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvionRevisionMecanicoDTO {
    
    private Long avionId;

    private String nombre;

    private String apellidos;

}
