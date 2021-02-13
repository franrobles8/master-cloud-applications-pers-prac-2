package com.mastercloudapps.airport.dto;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComunidadAutonomaNProvinciasDTO {
    
    @Field("_id")
    private String ca;
    private Integer numProvincias;

}
